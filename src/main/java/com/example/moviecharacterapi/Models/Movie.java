package com.example.moviecharacterapi.Models;

import jakarta.persistence.*;

import java.util.Set;

public class Movie {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    @Column(name = "movie_Name", length = 150)
    private String name;
    @ManyToMany
    private Set<Character> movies;

}
