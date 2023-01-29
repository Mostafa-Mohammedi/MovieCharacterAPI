package com.example.moviecharacterapi.CustomException;


import jakarta.persistence.EntityNotFoundException;

public class MovieCustomException extends EntityNotFoundException {

    public MovieCustomException(String message) {
        super(message);
    }

    public MovieCustomException(int id) {
        super("Movie doesnt exist with id: " + id);
    }


    public MovieCustomException() {
        super("There are no movies");
    }
}
