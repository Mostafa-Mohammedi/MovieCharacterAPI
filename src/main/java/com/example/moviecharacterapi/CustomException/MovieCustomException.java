package com.example.moviecharacterapi.CustomException;


import jakarta.persistence.EntityNotFoundException;

public class MovieCustomException extends EntityNotFoundException {
    public MovieCustomException(int id) {
        super("movie doesnt exist with id: " + id);
    }
}
