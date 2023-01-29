package com.example.moviecharacterapi.Services.Character;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Services.CrudServices;

import java.util.ArrayList;
import java.util.Collection;

public interface CharacterService extends CrudServices<Character, Integer> {

    //Collection<Character> findListOfCharacterByIds(ArrayList<Integer> listID);
}
