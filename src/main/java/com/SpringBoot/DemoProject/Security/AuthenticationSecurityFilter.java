package com.SpringBoot.DemoProject.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class AuthenticationSecurityFilter extends OncePerRequestFilter {

    private UserDetailsService userDetailsService;
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authentication = request.getHeader("Authorization");
        final String jwt;
        final String email;

        if(authentication==null||authentication.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }

        jwt = authentication.substring(7);
        email = jwtUtils.ExtractEmail(jwt);

        if(email!=null&& SecurityContextHolder.getContext().getAuthentication()==null){

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            if(jwtUtils.TokenValidation(jwt,userDetails)){
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails,null,jwtUtils.ExtractRole(jwt));
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        }
        filterChain.doFilter(request,response);
    }

}
