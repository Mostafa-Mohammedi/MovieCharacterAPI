package com.example.moviecharacterapi.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * the character class used as an entity to create the database
 * we used the lombok to set getters and setters
 */
@Entity
@Data
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullname;

    private String alias;

    private String gender;

    private String picture;

    @ManyToMany
    private Set<Movie> movies;

}
