package org.example.firstproj.Controller;

import org.example.firstproj.Entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.example.firstproj.Repo.utilisateurRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    public utilisateurRepo userRepo;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username , @RequestParam("password") String password){

        Utilisateur utilisateur = userRepo.findByNameContains(username);
        if(utilisateur.getMotDePasse().equals(password) && utilisateur.getNomUtilisateur() !=null){
            return "redirect:main";
        }else{
            return "redirect:/Login?error=true";
        }

    }
    @GetMapping("/login")
    public String loginPage(){
        return "Login";
    }
}
