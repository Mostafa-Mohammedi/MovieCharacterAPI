package com.example.moviecharacterapi.Services.Franchise;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Services.CrudServices;

import java.util.Collection;

/**
 * The franchise service is in charge of the extra functionality for character class
 *
 */
public interface FranchiseService extends CrudServices<Franchise,  Integer> {

    void updateMoviesInFranchise(int franchiseId, int[] listmovieId);
    Collection<Movie> getAllMoviesInfranchise(int franchiseId);

}
