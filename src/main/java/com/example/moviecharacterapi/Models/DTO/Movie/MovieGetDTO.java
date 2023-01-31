package com.example.moviecharacterapi.Models.DTO.Movie;

import lombok.Data;

import java.util.Set;

@Data
public class MovieGetDTO {
    private int Id;
    private String title;
    private String year;
    private String director;
    private String picture;

    private String trailer;
    private int franchises;

}
