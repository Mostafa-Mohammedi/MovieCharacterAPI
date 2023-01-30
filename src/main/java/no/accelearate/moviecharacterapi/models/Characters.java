package no.accelearate.moviecharacterapi.models;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.Set;


@Entity
@Table(name = "tb_characters")
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String  fullName;

    private String alias;

    private String gender;

    private Blob picture;

    @ManyToMany
    private Set<Movies> movies;
}
