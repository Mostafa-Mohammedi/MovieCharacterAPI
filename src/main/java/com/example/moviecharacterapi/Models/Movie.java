package com.example.moviecharacterapi.Models;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;

import java.util.Set;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.PERSIST;
import static org.hibernate.annotations.OnDeleteAction.*;

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

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "movies")
    private Set<Character> character;





}
