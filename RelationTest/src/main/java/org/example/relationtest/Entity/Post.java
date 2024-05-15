package org.example.relationtest.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_obj;

}