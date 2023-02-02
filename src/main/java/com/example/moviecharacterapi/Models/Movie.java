package com.example.moviecharacterapi.Models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="franchise_id")
    private Franchise franchise;

    @ManyToMany
    @JoinTable(name="movie_character",joinColumns = @JoinColumn(name="movie_id",referencedColumnName = "id"),inverseJoinColumns =@JoinColumn(name="character_id",referencedColumnName = "id") )
    private Set<Character> characters;

}
