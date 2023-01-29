package com.example.moviecharacterapi.Services.Movie;

import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Services.CrudServices;

import java.util.Collection;

public interface MovieService extends CrudServices<Movie, Integer> {

    Collection<Movie>  findAllMoviesByFranchiseName(String name);
    Collection<Character> findAllCharacterInMovie(String movieName);



}
