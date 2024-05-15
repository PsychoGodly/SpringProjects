package org.example.newapp1.web;


import org.example.newapp1.Entity.Employee;
import org.example.newapp1.Entity.Login_user;
import org.example.newapp1.Repo.EmployeeRepo;
import org.example.newapp1.Repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    public EmployeeRepo employeeRepo;

    @Autowired
    public LoginRepo loginRepo;

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes) {

        Login_user user = loginRepo.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/Employees";
        } else {
            redirectAttributes.addFlashAttribute("message", "Invalid username or password");
            return "redirect:/login";
        }
    }
    @GetMapping("/")
    public String test() {
        return "redirect:/Employees";
    }


    @GetMapping("/Employees")
    public String Affiche_Employees(Model model) {

        List<Employee> employees = employeeRepo.findAll();


        model.addAttribute("employees", employees);

        return "index";
    }

    @GetMapping("/ajoute_Emp")
    public String Ajout_Emp() {
        return "ajouteEmp";
    }

    @PostMapping("/ajoute_Emp")
    public String Ajout_Emp(@RequestParam("nom") String nom,
                            @RequestParam("prenom") String prenom,
                            @RequestParam("age") int age,
                            Model model
                            ) {

        Employee emp = new Employee();
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setAge(age);

        
        employeeRepo.save(emp);

        return "redirect:/Employees";

    }

    @GetMapping("/supprimer")
    public String Emp_Supprimer(@RequestParam("id") Long id) {
        employeeRepo.deleteById(id);
        return "redirect:/Employees";
    }

    @GetMapping("/modifier")
    public String Modifier(@RequestParam("id") Long id ,Model model) {
        Employee emp = employeeRepo.findById(id).orElse(null);

        if (emp != null) {
            model.addAttribute("empM", emp);
            return "modifier";
        } else {
            return "redirect:/Employees";
        }
    }

    @PostMapping("/modifier/{id}")
    public String Modifier(@ModelAttribute Employee emp) {
        employeeRepo.save(emp);
        return "redirect:/Employees";
    }


    @GetMapping("/recherche")
    public String rechercheEmployesParNom(@RequestParam("nom") String nom,Model model) {
        model.addAttribute("emp", employeeRepo.findByNomContains(nom));
        return "index";
    }

}
