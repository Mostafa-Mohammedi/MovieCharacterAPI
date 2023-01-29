package com.example.moviecharacterapi.Repository;
import com.example.moviecharacterapi.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovie extends JpaRepository<Integer, Movie> {
}
