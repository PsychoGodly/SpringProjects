package org.example.onetomany.Controller;

import org.example.onetomany.Entity.Person;
import org.example.onetomany.Repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    public PersonRepo personRepo;

    @GetMapping("/index")
    public String index(Model model) {
        List<Person> persons = personRepo.findAll();
        model.addAttribute("persons", persons);
        return "index";
    }


}
