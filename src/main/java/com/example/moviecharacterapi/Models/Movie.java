package com.example.moviecharacterapi.Models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * the Movie class used as an entity to create the database
 * we used the lombok to set getters and setters
 */
@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;


    private String genre;

    private String year;

    private String director;

    private String picture;

    private String trailer;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="movie_character",
            joinColumns = @JoinColumn(name="movie_id"),
            inverseJoinColumns = @JoinColumn(name="character_id")

    )
    private Set<Character> characters;

}
