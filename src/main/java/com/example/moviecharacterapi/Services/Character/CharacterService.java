package com.example.moviecharacterapi.Services.Character;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Services.CrudServices;

import java.util.ArrayList;
import java.util.Collection;

/**
 * The character servcie is in charge of the extra functionality for character class
 *
 */
public interface CharacterService extends CrudServices<Character, Integer> {

    //Collection<Character> findListOfCharacterByIds(ArrayList<Integer> listID);
}
