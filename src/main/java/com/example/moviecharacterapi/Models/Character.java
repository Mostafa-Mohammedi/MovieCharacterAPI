package com.example.moviecharacterapi.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Character {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int character_Id;
    @Column(name = "actor_Name", length = 250, nullable = false)
    private String fullName;

    @Column(name = "character_Name", length = 250, nullable = true)
    private String alias;

    @Column(name = "genderType", length = 250, nullable = true)
    private String gender;

    @Column(name = "picture")
    private String picture;

    @ManyToMany
    private Set<Movie> movies;


}
