package com.example.moviecharacterapi.Repository;
import com.example.moviecharacterapi.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Movie JPA repository is in charge of the crud operation for movies
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {




}
