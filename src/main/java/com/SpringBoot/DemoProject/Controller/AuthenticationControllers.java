package com.SpringBoot.DemoProject.Controller;

import com.SpringBoot.DemoProject.Model.User;
import com.SpringBoot.DemoProject.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationControllers {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public String Register (@RequestBody User user) {
        return authenticationService.register(user);
    }

}

