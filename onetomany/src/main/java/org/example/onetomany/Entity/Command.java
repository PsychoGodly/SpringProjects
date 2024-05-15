package org.example.onetomany.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String command;
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "Person_id", nullable = false)
    private Person person;


}
