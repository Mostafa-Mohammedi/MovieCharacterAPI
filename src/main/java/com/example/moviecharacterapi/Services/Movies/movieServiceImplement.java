package com.example.moviecharacterapi.Services.Movies;
import com.example.moviecharacterapi.CustomException.MovieCustomException;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Repository.CharacterRepository;
import com.example.moviecharacterapi.Repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class movieServiceImplement implements MovieService{

    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;
    private final Logger logger = LoggerFactory.getLogger(movieServiceImplement.class);


    public movieServiceImplement(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
    }

    /**
     * Method for finding a movie by id. The findBy id JPA from the franchise repository
     * @param id takes the integer as id
     * @return the movie that it find by id
     */
    @Override
    public Movie findById(Integer id) {
         return  movieRepository.findById(id).orElseThrow(() -> new MovieCustomException(id));
    }


    /**
     * Method for finding alle the movie  check if the database is empty or first
     * @return returns a list of movie
     */
    @Override
    public Collection<Movie> findAll() {
        if(movieRepository.findAll().size() != 0){
            Collection<Movie> movies= movieRepository.findAll();
            return movies;
        }

        else{
            throw new MovieCustomException();
        }
    }


    /**
     * Takes a movie object and saves it to the database
     * @param entity takes the movie object
     * @return the movie object
     */
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

    /**
     * Takes a movie object and update the data
     * @param movie takes the movie object
     * @return the saved movie object
     */
    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void updateCharacterInMovie(int movieId, int[] characters) {
        Movie movie = movieRepository.findById(movieId).get();
        Set<Character> characterSet = new HashSet<>();

        if(characters.length == 0){
            throw new MovieCustomException("the list is empty ");
        }
        for (int id: characters) {
            characterSet.add(characterRepository.findById(id).get());
        }
        movie.setCharacters(characterSet);
        movieRepository.save(movie);
    }

    @Override
    public Collection<Character> getCharacterMovie(int movieId) {
        return movieRepository.findById(movieId).get().getCharacters();
    }


    /**
     * Method for checking if the franchise exist in the database
     * takes the entity and sets the related content to null
     * delets the franchise
     * @param id takes an id as integer
     */
    @Override
    public void deleteById(Integer id) {
        if(movieRepository.existsById(id)){
            Movie movieDelete = movieRepository.findById(id).get();
            movieDelete.getCharacters().forEach(s -> s.setMovies(null));
            movieRepository.delete(movieDelete);
        }
        else{
            logger.warn("No movie exists with ID: " + id);        }

    }

}
