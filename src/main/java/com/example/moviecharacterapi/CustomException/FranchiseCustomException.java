package com.example.moviecharacterapi.CustomException;

import jakarta.persistence.EntityNotFoundException;

/**
 * custom exception for franchise
 */
public class FranchiseCustomException extends EntityNotFoundException {

    public FranchiseCustomException(String message) {
        super(message);
    }

    public FranchiseCustomException(int id) {
        super("Franchise doesnt exist with id: " + id);

    }

    public FranchiseCustomException() {
        super("There are no Franchise");
    }
}
