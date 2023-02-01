package com.example.moviecharacterapi.Models.DTO.Movie;

import lombok.Data;

@Data
public class UpdateMovieDTO {
    private int Id;
    private String title;
    private String year;
    private String director;
    private String picture;
    private String trailer;
}
