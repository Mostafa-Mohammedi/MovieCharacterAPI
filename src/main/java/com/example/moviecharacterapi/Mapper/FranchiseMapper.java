package com.example.moviecharacterapi.Mapper;

import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.FranchiseDTO.FranchiseDTO;
import com.example.moviecharacterapi.Models.FranchiseDTO.UpdateFranchiseDTO;
import com.example.moviecharacterapi.Models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")

public interface FranchiseMapper {
    @Mapping(target = "movies", qualifiedByName = "listMovies")

    FranchiseDTO franchiseDTO(Franchise franchise);

    Franchise updateFranchise(UpdateFranchiseDTO updateFranchiseDTO);
    Collection<FranchiseDTO> listFranchiseDTo(Collection<Franchise> franchises);

    @Named(value = "listMovies")
    default Set<Integer> map(Set<Movie> value){
        if(value == null){
            return null;
        }
        return value.stream().map(Movie::getId).collect(Collectors.toSet());
    }

}
