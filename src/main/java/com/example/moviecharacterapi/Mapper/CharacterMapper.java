package com.example.moviecharacterapi.Mapper;

import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.CharacterDTO.CharacterAllDTO;
import com.example.moviecharacterapi.Models.CharacterDTO.CharacterDTO;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
  // @Mapping(target = "movies", source = "movies", qualifiedByName = "listTesting")
    CharacterAllDTO characterDTO(Character character);
    Character character(CharacterDTO characterDTO);
    Collection<CharacterDTO> listCharacter(Collection<Character> characters);



    /*
    @Named(value = "listTesting")
    default Set<Integer> map(Set<Movie> value) {
        if (value == null) {
            return null;
        }
        return value.stream().map(Movie::getId).collect(Collectors.toSet());
    }

 */
}
