package com.SpringBoot.DemoProject.Service;

import com.SpringBoot.DemoProject.Model.Login;
import com.SpringBoot.DemoProject.Model.Enum.Role;
import com.SpringBoot.DemoProject.Model.User;
import com.SpringBoot.DemoProject.Repository.UserRepository;
import com.SpringBoot.DemoProject.Security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedOn(LocalDate.now());
        user.setStatus(true);
        user.setRole(Role.USER);

        userRepository.save(user);
        return " Register Successfully .....! ";
    }

    public ResponseEntity<?> login (Login login){
        try{
            Authentication authentication = new UsernamePasswordAuthenticationToken(login.getUserName(),login.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(" UserName And Password is in valid ......! ");
        }

        Optional<User> username = userRepository.findByEmail(login.getUserName());
        if(username.isPresent()){
            String Token = jwtUtils.CreateToken(new HashMap<>(),username.get());
            return ResponseEntity.ok(Token);
        }else{
            return ResponseEntity.noContent().build();
        }

    }

}

