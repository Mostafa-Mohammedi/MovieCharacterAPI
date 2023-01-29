package com.example.moviecharacterapi.Repository;

import com.example.moviecharacterapi.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFranchise extends JpaRepository<Integer, Movie> {


}
