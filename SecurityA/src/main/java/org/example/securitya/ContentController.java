package org.example.securitya;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping(value = {"/home", "/"})
    public String home() {
        return "home";
    }


    @GetMapping("/login")
    public String login() {

        return "login_page";
    }

    @GetMapping("/admin/home")
    public String adminHome() {

        return "adminPage";
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "userAdmin";
    }
}
