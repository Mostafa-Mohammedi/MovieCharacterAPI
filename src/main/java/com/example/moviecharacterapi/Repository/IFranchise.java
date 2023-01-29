package com.example.moviecharacterapi.Repository;

import com.example.moviecharacterapi.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface IFranchise extends JpaRepository<Integer, Movie> {



}
