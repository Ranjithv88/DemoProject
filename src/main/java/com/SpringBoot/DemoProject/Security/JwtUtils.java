package com.SpringBoot.DemoProject.Security;

import com.SpringBoot.DemoProject.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class JwtUtils {

    private static final Logger logger = Logger.getLogger(JwtUtils.class.getName());

    @Value("${spring.jwtToken.secretKey}")
    private String SECRET_KEY;

    public String CreateToken (Map<String,Object> extractClaims , User LoginDetails ){
        logger.info(" Generate Token  .......! ");
        extractClaims.put("email",LoginDetails.getEmail());
        extractClaims.put("role",LoginDetails.getAuthorities());
        return Jwts.builder().setClaims(extractClaims).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +1000*60*60*10))
                .signWith(SignInKey(), SignatureAlgorithm.HS384).compact();
    }

    public Key SignInKey () {
        byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(KeyBytes);
    }

    public Claims ExtraClaims(String Token) {
        return Jwts.parser().setSigningKey(SignInKey()).build().parseClaimsJws(Token).getBody();
    }

    public String extractEmail (String Token) {
        logger.info(" Extract Email ....... ! ");
        return ExtraClaims(Token).get("email").toString();
    }

    public Collection<? extends GrantedAuthority> extractRole (String Token){
        Object RoleClaims = ExtraClaims(Token).get("role");
        logger.info(" Extract Role ......! ");
        if(RoleClaims instanceof List<?>){
            List<HashMap<String,String>> Roles = (List<HashMap<String,String>>) RoleClaims;
            System.out.println(Roles);
            return Roles.stream().map(x-> new SimpleGrantedAuthority(x.get("authority"))).collect(Collectors.toSet());
        }else {
            return List.of( new SimpleGrantedAuthority(null));
        }
    }

    public Date ExtractExpiration (String Token) {
        logger.info(" Extract Token Expiration ...... ! ");
        return ExtraClaims(Token).getExpiration();
    }

    public Boolean validateExpiration (String Token) {
        logger.info(" Extract Token validate ...... ! ");
        System.out.println(ExtractExpiration(Token).before(new Date()));
        return ExtractExpiration(Token).before(new Date());
    }

    public Boolean TokenValidation (String Token, UserDetails userDetails) {
        final String username = extractEmail(Token);
        return (username.equals(userDetails.getUsername())) && !validateExpiration(Token);
    }

}

