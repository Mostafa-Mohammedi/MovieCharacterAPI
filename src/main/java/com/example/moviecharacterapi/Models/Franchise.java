package com.example.moviecharacterapi.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Franchise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int franchise_id;
    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description", length = 500)
    private String franchiseDescription;

    @OneToMany(mappedBy = "franchise")
    private Set <Movie> movies;


}
