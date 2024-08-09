package com.SpringBoot.DemoProject.Security;

import com.SpringBoot.DemoProject.Exception.authenticationEntryPoint;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.net.http.HttpRequest;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

    private AuthenticationSecurityFilter securityFilterChain;
    private authenticationEntryPoint entryPoint;
    private AuthenticationProvider authenticationProvider;

    private final String[] paths = {"/register","/login","/user/get/**","/seller/**","/admin/**","/test"};


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception->exception.authenticationEntryPoint(entryPoint))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authentication->
                        authentication.requestMatchers(paths[0],paths[1],paths[5]).permitAll()
                                .requestMatchers("/user/get/**").hasAuthority("USER")
                                .requestMatchers(paths[2],paths[3]).hasAuthority("SELLER")
                                .requestMatchers(paths[4]).hasAuthority("ADMIN")
                                .requestMatchers(paths).hasAuthority("DEVELOPER")
                        );
        httpSecurity.authenticationProvider(authenticationProvider);
        httpSecurity.addFilterBefore(securityFilterChain,UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

}

