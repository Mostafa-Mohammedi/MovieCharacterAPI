package com.example.moviecharacterapi.Services.Movie;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Services.CrudServices;

import java.util.ArrayList;
import java.util.Collection;

public interface MovieService extends CrudServices<Movie, Integer> {

    void deleteMovieByName(String name);
    void updateCharacterInMovie(int movieId,int[] characters);



}
