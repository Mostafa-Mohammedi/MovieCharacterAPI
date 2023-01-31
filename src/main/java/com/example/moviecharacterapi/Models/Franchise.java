package com.example.moviecharacterapi.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Franchise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int franchise_id;
    private String name;

    private String description;

    @OneToMany(mappedBy = "franchise")
    private Set <Movie> movies;


}
