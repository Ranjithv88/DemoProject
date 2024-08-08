package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Model.Login;
import com.SpringBoot.DemoProject.Model.User;
import com.SpringBoot.DemoProject.Service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationControllers {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<String> register (@Valid @RequestBody User user) {
        return ResponseEntity.ok().body(authenticationService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login ( @Valid @RequestBody Login login) {
        return authenticationService.login(login);
    }

}

