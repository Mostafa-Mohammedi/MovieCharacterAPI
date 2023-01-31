package com.example.moviecharacterapi.Mapper;

import com.example.moviecharacterapi.Models.DTO.Movie.MovieGetDTO;
import com.example.moviecharacterapi.Models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;


@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "franchises", source = "franchise.id")
    MovieGetDTO movieGetDTO(Movie movie);
    Collection<MovieGetDTO> listMovieDTO(Collection<Movie> movies);
}
