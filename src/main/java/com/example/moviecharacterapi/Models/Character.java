package com.example.moviecharacterapi.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Character {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int character_Id;
    @Column(name = "actor_name", length = 250, nullable = false)
    private String fullName;

    private String alias;

    private String gender;

    @Column(name = "picture")
    private String picture;

    @ManyToMany
    private Set<Movie> movies;




}
