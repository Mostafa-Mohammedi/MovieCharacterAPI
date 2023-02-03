package com.example.moviecharacterapi.Services.Character;
import com.example.moviecharacterapi.CustomException.CharacterCustomException;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Repository.CharacterRepository;
import com.example.moviecharacterapi.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The character service implementation.
 * Does the business logic for the crud and extra functionality
 */
@Service
public class CharacterServiceImplement implements CharacterService{
    private final CharacterRepository characterRepository;
    private final MovieRepository movieRepository;
    public CharacterServiceImplement(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }

    /**
     * Method for finding a character by id implements the findBy id JPA from the character repository
     * @param integer takes the integer as id
     * @return the character that it find by id
     */
    @Override
    public Character findById(Integer integer) {
        return characterRepository.findById(integer).orElseThrow(() -> new CharacterCustomException(integer));
    }
    /**
     * Method for finding alle the character  check if the database is empty or first
     * @return returns a list of characters
     */
    @Override
    public Collection<Character> findAll() {
        if(characterRepository.findAll().size() > 0){
            Collection<Character> characters=characterRepository.findAll();
            return characters;
        }
        else {
            throw new CharacterCustomException();
        }
    }
    /**
     * Takes a character object and saves it to the database
     * @param entity takes the character object
     * @return the saved character object
     */

    @Override
    public Character add(Character entity) {
        return  characterRepository.save(entity);
    }

    /**
     * Takes a character object and update the data
     * @param entity takes the character object
     * @return the saved character object
     */
    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }


    /**
     * Method for checking if the character exist in the database
     * takes the entity and sets the related content to null
     * delets the character
     * @param integer takes an id as integer
     */
    @Override
    public void deleteById(Integer integer) {
        var deleteActor = characterRepository.findById(integer).get();
        Set<Movie> movies= movieRepository.findAll().stream().filter(movie ->
            movie.getCharacters().contains(deleteActor)).collect(Collectors.toSet());
        movieRepository.deleteAll(movies);
        characterRepository.delete(deleteActor);
    }

}
