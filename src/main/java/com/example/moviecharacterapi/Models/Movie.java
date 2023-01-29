package com.example.moviecharacterapi.Models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String title;


    private String genre;

    private String releaseYear;


    private String director;

    private String picture;

    private String trailer;


    @ManyToOne
    @JoinColumn(name = "movies")
    private Franchise franchise;

/*

    @ManyToMany
    private Set<Character> charactersSet;


     */


}
