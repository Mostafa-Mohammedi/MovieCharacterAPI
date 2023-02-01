package com.example.moviecharacterapi.Mapper;

import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.CharacterDTO.CharacterDTO;
import org.mapstruct.Mapper;
import java.util.Collection;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterDTO characterDTO(Character character);
    Character updateCharater(CharacterDTO characterDTO);
    Collection<CharacterDTO> listMovieDTO(Collection<Character> characters);

}
