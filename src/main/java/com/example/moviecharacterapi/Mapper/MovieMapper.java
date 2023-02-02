package com.example.moviecharacterapi.Mapper;

import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.MovieDTO.MovieAllDTO;
import com.example.moviecharacterapi.Models.MovieDTO.MovieDTO;
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
public abstract class MovieMapper {
    @Mapping(target = "franchises", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "listTesting")
    public abstract MovieAllDTO movieDTO(Movie movie);
    public abstract Movie updateMovie(MovieDTO movieDTO);
    public abstract Movie CreateMovie(MovieDTO movieCreateDTO);

    public abstract Movie deleteMovie(MovieDTO movieDTO);

    public abstract Collection<MovieAllDTO> listMovieDTO(Collection<Movie> movies);

    @Named(value = "listTesting")
    Set<Integer> map(Set<Character> value){
        if(value == null){
            return null;
        }
        return value.stream().map(Character::getId).collect(Collectors.toSet());
    }
}
