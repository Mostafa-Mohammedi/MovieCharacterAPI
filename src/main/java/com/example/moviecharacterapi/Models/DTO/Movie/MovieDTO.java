package com.example.moviecharacterapi.Models.DTO.Movie;

import lombok.Data;

import java.util.Set;

@Data
public class MovieDTO {
    private int Id;
    private String title;
    private String year;
    private String director;
    private String picture;

    private String trailer;
    private int franchises;
    private Set<Integer> character;

}
