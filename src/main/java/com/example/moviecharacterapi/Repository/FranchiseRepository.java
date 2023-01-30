package com.example.moviecharacterapi.Repository;

import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

    Franchise findFranchiseByName(String name);




}
