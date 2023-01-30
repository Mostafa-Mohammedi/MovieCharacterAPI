package no.accelearate.moviecharacterapi.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_franchise")
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String  name;

    private String description;

    @OneToMany(mappedBy = "franchise" )
    private Set<Movies> movies;
}
