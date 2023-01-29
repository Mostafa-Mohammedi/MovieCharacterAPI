package com.example.moviecharacterapi.Services.Movie;

import com.example.moviecharacterapi.CustomException.MovieCustomException;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Repository.CharacterRepository;
import com.example.moviecharacterapi.Repository.MovieRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class movieServiceImplement implements MovieService{

    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    public movieServiceImplement(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
    }

    @Override
    public Movie findById(Integer id) {
         return  movieRepository.findById(id).orElseThrow(() -> new MovieCustomException(id));
    }

    @Override
    public Collection<Movie> findAll() {
        if(movieRepository.findAll().size() != 0){
            return movieRepository.findAll();
        }
        else{
            throw new MovieCustomException();
        }
    }

    @Override
    public Movie add(Movie entity) {

        List<Movie> listMovies = movieRepository.findAll();
        for ( Movie movie: listMovies) {
            if(!entity.getTitle().equals(movie.getTitle())){
                return movieRepository.save(entity);
            }

        }
        throw new MovieCustomException("movie already exist ");
    }

    @Override
    public Movie update(Movie entity) {

        List<Movie> listMovies = movieRepository.findAll();

        for (Movie movie: listMovies) {
            if(movieRepository.findMovieByName(entity.getTitle()).equals(movie.getTitle())){
                return movieRepository.save(entity);
            }
        }
        throw  new MovieCustomException("movie doesnt exist, cannot update");
    }

    @Override
    public void deleteMovieByName(String name) {
        var movie = movieRepository.findMovieByName(name);
        if(movie != null){
            movieRepository.delete(movie);
        }
        else{
            throw new MovieCustomException("didnt find the movie, check for spelling");
        }

    }

    @Override
    public Collection<Character> updateCharacterInMovie(ArrayList<Integer> listCharacter) {

        Collection<Character> actorList = movieRepository.findCharactersByCharacter_Id(listCharacter);

        characterRepository.saveAll(actorList);

        return actorList;
    }


    @Override
    public void deleteById(Integer id) {
        var movieDelete = movieRepository.findById(id).orElseThrow(() -> new MovieCustomException(id));
        movieRepository.deleteById(movieDelete.getMovieId());
    }
}