package com.example.moviecharacterapi.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Character {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int character_Id;
    private String fullname;

    private String alias;

    private String gender;

    private String picture;

    @ManyToMany
    private Set<Movie> movies;


}
