package com.example.moviecharacterapi.Models.MovieDTO;

import lombok.Data;

import java.util.Set;

/**
 * Method for getting movies with the relationship
 */

@Data
public class MovieAllDTO {
    private int Id;
    private String title;
    private String year;
    private String director;
    private String picture;

    private String trailer;
    private int franchises;
    private Set<Integer> characters;

}
