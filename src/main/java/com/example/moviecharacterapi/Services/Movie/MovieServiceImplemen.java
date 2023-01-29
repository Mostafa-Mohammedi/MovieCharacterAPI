package com.example.moviecharacterapi.Services.Movie;

import com.example.moviecharacterapi.CustomException.MovieCustomException;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Repository.MovieRepository;

import java.util.Collection;

public class MovieServiceImplemen implements MovieService{

    private final MovieRepository movieRepository;

    public MovieServiceImplemen(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Movie findById(Integer id) {
         return  movieRepository.findById(id).orElseThrow(() -> new MovieCustomException(id));
    }


    @Override
    public Collection<Movie> findAll() {
        return null;
    }

    @Override
    public Movie add(Movie entity) {
        return null;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public Collection<Movie> findAllMoviesByFranchiseName(String name) {
        return null;
    }

    @Override
    public Collection<Character> findAllCharacterInMovie(String movieName) {
        return null;
    }
}
