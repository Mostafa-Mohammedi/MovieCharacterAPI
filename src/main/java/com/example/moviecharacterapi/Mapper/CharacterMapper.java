package com.example.moviecharacterapi.Mapper;

import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.CharacterDTO.CharacterAllDTO;
import com.example.moviecharacterapi.Models.CharacterDTO.CharacterDTO;
import com.example.moviecharacterapi.Models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * the mapper class create a mapping for the DTO and the Entity class
 *
 */
@Mapper(componentModel = "spring")
public abstract class CharacterMapper {
    @Mapping(target = "movies", source = "movies", qualifiedByName = "listTesting")
    public abstract CharacterAllDTO characterDTO(Character character);
    public abstract Character character(CharacterDTO characterDTO);
    public abstract Collection<CharacterDTO> listCharacter(Collection<Character> characters);


    @Named(value = "listTesting")
    Set<Integer> map(Set<Movie> value) {
        if (value == null) {
            return null;
        }
        return value.stream().map(Movie::getId).collect(Collectors.toSet());
    }


}
