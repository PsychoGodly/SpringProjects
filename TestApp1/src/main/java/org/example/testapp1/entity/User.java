package org.example.testapp1.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class User {

    @NotBlank(message = "Name is test")
    private String name;

    @NotBlank(message = "Email is test")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is test")
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;

}