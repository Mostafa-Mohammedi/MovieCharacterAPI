package com.example.moviecharacterapi.Services.Franchise;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Services.CrudServices;

import java.util.Collection;

public interface FranchiseService extends CrudServices<Franchise,  Integer> {
    Collection<Movie> findAllMoviesByFranchiseName(String name);


}
