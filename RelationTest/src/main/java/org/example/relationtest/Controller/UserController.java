package org.example.relationtest.Controller;

import org.example.relationtest.Entity.User;
import org.example.relationtest.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "index";
    }


}
