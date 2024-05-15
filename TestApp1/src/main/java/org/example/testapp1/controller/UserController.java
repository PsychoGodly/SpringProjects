package org.example.testapp1.controller;

import jakarta.validation.Valid;
import org.example.testapp1.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration-form";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration-form";
        } else {
            // Logic to save the user to the database
            return "registration-success";
        }
    }
}
