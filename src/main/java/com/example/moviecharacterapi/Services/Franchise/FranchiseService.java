package com.example.moviecharacterapi.Services.Franchise;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Services.CrudServices;

import java.util.Collection;

public interface FranchiseService extends CrudServices<Franchise,  Integer> {

    void updateMoviesInFranchise(int franchiseId, int[] listmovieId);

}
