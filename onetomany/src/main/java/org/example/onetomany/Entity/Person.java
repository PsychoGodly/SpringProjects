package org.example.onetomany.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "person")
    private List<Command> commands;

    @ManyToMany
    @JoinTable(
            name = "Persons_Courses",
            joinColumns = @JoinColumn(name = "Person_id"),
            inverseJoinColumns = @JoinColumn(name = "Courses_id")
    )
    private List<Course> courses ;
}
