package com.SpringBoot.DemoProject.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login {

    @NotBlank(message = " Email is Mandatory ! ")
    @Email(message = " Not Valid Email ! ")
    private String userName;

    @NotBlank(message = " password is Mandatory ! ")
    @Size(min = 8,message = " Too weak ! ")
    private String password;

}

