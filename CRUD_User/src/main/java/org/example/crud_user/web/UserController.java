package org.example.crud_user.web;

import org.example.crud_user.Entity.User;
import org.example.crud_user.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/affiche")
    public String Affiche(Model model) {
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "Affiche";
    }


    @PostMapping("/ajout")
    public String Ajoute(@RequestParam("nom") String nom ,@RequestParam("age") int age){
        User newUser = new User();
        newUser.setNom(nom);
        newUser.setAge(age);
        userRepo.save(newUser);
        return "Ajoute";
    }


    @GetMapping("/ajout")
    public String afficherFormulaireAjout() {
        return "Ajoute";
    }


    @GetMapping("/supprimer")
    public String Supp(@RequestParam("id") int id){
        userRepo.deleteById(id);
        return "redirect:/affiche";
    }


    @GetMapping("/modifier")
    public String AfficheForm(@RequestParam("id") int id ,Model model){
        User user = userRepo.findById(id).orElse(null);
        model.addAttribute("user", user);
        return user != null ? "/Modifier" : "redirect:/affiche";
    }

    @PostMapping("/modifier")
    public String ModifierForm(@ModelAttribute User user){
        userRepo.save(user);
        return "redirect:/affiche";
    }








}
