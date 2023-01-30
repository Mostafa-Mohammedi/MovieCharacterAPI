package no.accelearate.moviecharacterapi.models;

import jakarta.persistence.*;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tb_movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String title;

    private String  genre;

    private String releaseyear;

    private String director;

    private String picture;

    private String trailer;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToMany(mappedBy = "movies")
    private Set<Characters> characters;
}
