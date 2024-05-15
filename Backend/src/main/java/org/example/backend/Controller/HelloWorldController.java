package org.example.backend.Controller;

import org.example.backend.Entity.Contact;
import org.example.backend.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return userRepository.findAll();
    }

    @GetMapping("/add-contact")
    public Contact add_Contact(@RequestBody Contact contact) {
        return userRepository.save(contact);
    }



}