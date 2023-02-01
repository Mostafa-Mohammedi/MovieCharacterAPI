package com.example.moviecharacterapi.Mapper;

import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.DTO.Movie.MovieDTO;
import com.example.moviecharacterapi.Models.DTO.Movie.UpdateMovieDTO;
import com.example.moviecharacterapi.Models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "franchises", source = "franchise.id")
    @Mapping(target = "character", qualifiedByName = "listTesting")

    MovieDTO movieDTO(Movie movie);
    Movie updateMovie(UpdateMovieDTO movieDTO);
    Collection<MovieDTO> listMovieDTO(Collection<Movie> movies);

    @Named(value = "listTesting")
    default Set<Integer> map(Set<Character> value){
        if(value == null){
            return null;
        }
        return value.stream().map(Character::getId).collect(Collectors.toSet());

    }
}
