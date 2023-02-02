package com.example.moviecharacterapi.Services.Franchise;

import com.example.moviecharacterapi.CustomException.FranchiseCustomException;
import com.example.moviecharacterapi.CustomException.MovieCustomException;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Repository.FranchiseRepository;
import com.example.moviecharacterapi.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The franchise service implementation.
 * Does the business logic for the crud and extra functionality
 */

@Service
public class FranchiseServiceImplement implements FranchiseService{

    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;

    public FranchiseServiceImplement(FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }

    /**
     * Method for finding a franchise by id. The findBy id JPA from the franchise repository
     * @param integer takes the integer as id
     * @return the franchise that it find by id
     */
    @Override
    public Franchise findById(Integer integer) {
        return franchiseRepository.findById(integer).orElseThrow(() -> new FranchiseCustomException(integer));
    }

    /**
     * Method for finding alle the franchise  check if the database is empty or first
     * @return returns a list of franchise
     */

    @Override
    public Collection<Franchise> findAll() {
        if(franchiseRepository.findAll().size() != 0){
            return franchiseRepository.findAll();
        }
        else{
            throw new FranchiseCustomException();
        }
    }

    /**
     * Takes a franchise object and saves it to the database
     * @param entity takes the franchise object
     * @return the saved character object
     */
    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }
    /**
     * Takes a franchise object and update the data
     * @param entity takes the franchise object
     * @return the saved franchise object
     */
    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    /**
     * Method for checking if the franchise exist in the database
     * takes the entity and sets the related content to null
     * delets the franchise
     * @param integer takes an id as integer
     */

    @Override
    public void deleteById(Integer integer) {

        if(franchiseRepository.existsById(integer)){
            Franchise movieDelete = franchiseRepository.findById(integer).get();
            movieDelete.getMovies().forEach(s -> s.setFranchise(null));
            franchiseRepository.delete(movieDelete);
        }
    }

    /**
     * Method for taking the movies from franchise and updating them
     * @param franchiseId takes a id from franchise as a paramater
     * @param listmovieId takes an list of int that include all the list movies
     */
    @Override
    public void updateMoviesInFranchise(int franchiseId, int[] listmovieId) {
        Franchise franchise = franchiseRepository.findById(franchiseId).get();
        Set<Movie> movieList = new HashSet<>();

        for (int id: listmovieId) {
            movieList.add(movieRepository.findById(id).get());
        }

        franchise.setMovies(movieList);
        franchiseRepository.save(franchise);

    }

    /**
     * Method for getting all the movies from franchise
     * @param franchiseId takes the franchise id 
     * @return retursn a list of movies
     */
    @Override
    public Collection<Movie> getAllMoviesInfranchise(int franchiseId) {
        return franchiseRepository.findById(franchiseId).get().getMovies();
    }

    /**
     * Method for getting all the character from the franchise by finding the correct movie
     * @param franchiseId takes the character id
     * @param movieId takes a movie id
     * @return a collection of character
     */
    public Collection<Character> getAllCharacterFromFranchise(int franchiseId, int movieId){
        Collection<Movie> listMovies =  franchiseRepository.findById(franchiseId).get().getMovies();
        Movie correctMovie = movieRepository.findById(movieId).get();
        for (Movie movie: listMovies) {
            if(movie.equals(correctMovie)){
                return movieRepository.findById(movieId).get().getCharacters();
            }

        }
        throw  new MovieCustomException("the franchise doesnt have the character");
    }



}
