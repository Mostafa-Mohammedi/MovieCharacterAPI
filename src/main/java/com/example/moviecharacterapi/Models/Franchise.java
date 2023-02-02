package com.example.moviecharacterapi.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


/**
 * the Franchise class used as an entity to create the database
 * we used the lombok to set getters and setters
 */
@Entity
@Data
public class Franchise {

    @Id
    @Column(name = "franchise_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "franchise",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Movie> movies;

}
