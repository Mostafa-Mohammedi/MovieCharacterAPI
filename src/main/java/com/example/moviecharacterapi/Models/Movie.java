package com.example.moviecharacterapi.Models;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

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

    @ManyToMany(mappedBy = "movies")
    private Set<Character> character;





}
