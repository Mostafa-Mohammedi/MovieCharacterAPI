package com.example.moviecharacterapi.Models;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    @Column(name = "movie_title", length = 150)
    private String movieTitle;

    private String genre;


    @Column(length = 150)
    private String director;

    @Column(name = "picture")
    private String picture;

    @Column(name = "trailer")
    private String trailer;

    @ManyToMany
    private Set<Character> movies;

}
