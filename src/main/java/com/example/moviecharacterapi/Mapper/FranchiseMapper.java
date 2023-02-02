package com.example.moviecharacterapi.Mapper;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.FranchiseDTO.FranchiseAllDTO;
import com.example.moviecharacterapi.Models.FranchiseDTO.FranchiseDTO;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Models.MovieDTO.MovieAllDTO;
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
public abstract class  FranchiseMapper {
    @Mapping(target = "movies", qualifiedByName = "listMovies")
   public abstract FranchiseAllDTO franchiseDTO(Franchise franchise);
    public abstract Franchise updateFranchise(FranchiseDTO updateFranchiseDTO);

    public abstract Franchise createFranchise(FranchiseDTO franchiseCreateDTO);

    //public abstract Collection<MovieAllDTO> listMovieDTO(Collection<Movie> movies);
    public abstract Collection<FranchiseAllDTO> listFranchiseDTo(Collection<Franchise> franchises);
    @Named(value = "listMovies")
    Set<Integer> map(Set<Movie> value){
        if(value == null){
            return null;
        }
        return value.stream().map(Movie::getId).collect(Collectors.toSet());
    }
}
