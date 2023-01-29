package com.example.moviecharacterapi.Repository;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Collection;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieByName(String name);

    Collection<Character> findCharactersByCharacter_Id(ArrayList<Integer> listCharacter);

}