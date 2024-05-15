package org.example.onetomany.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String course_name;
    private int nbr_of_person;

    @ManyToMany(mappedBy = "courses")
    private List<Person> persons;

}
