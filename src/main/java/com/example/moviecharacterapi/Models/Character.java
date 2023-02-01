package com.example.moviecharacterapi.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

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
