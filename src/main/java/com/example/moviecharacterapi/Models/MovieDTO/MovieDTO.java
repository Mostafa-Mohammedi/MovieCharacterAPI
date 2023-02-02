package com.example.moviecharacterapi.Models.MovieDTO;
import lombok.Data;

/**
 * Method for getting character without the relationship
 */

@Data
public class MovieDTO {
    private int Id;
    private String title;
    private String year;
    private String director;
    private String picture;
    private String trailer;

}
