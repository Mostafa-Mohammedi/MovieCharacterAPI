package com.example.moviecharacterapi.Services.Movies;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Services.CrudServices;

import java.util.Collection;


/**
 * The movie service is in charge of the extra functionality for character class
 *
 */
public interface MovieService extends CrudServices<Movie, Integer> {
    void updateCharacterInMovie(int movieId,int[] characters);

    Collection<Character> getCharacterMovie(int movieId);





}
