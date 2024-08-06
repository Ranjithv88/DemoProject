package com.SpringBoot.DemoProject.Service;

import com.SpringBoot.DemoProject.Model.Role;
import com.SpringBoot.DemoProject.Model.User;
import com.SpringBoot.DemoProject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    public String register(User user) {
        user.setCreatedOn(LocalDate.now());
        user.setStatus(true);
        user.setRole(Role.USER);
        userRepository.save(user);
        return " Register Successfully .....! ";
    }

}

