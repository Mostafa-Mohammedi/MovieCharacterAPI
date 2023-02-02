package com.example.moviecharacterapi.CustomException;

import jakarta.persistence.EntityNotFoundException;

/**
 * The custom character exception class
 */
public class CharacterCustomException extends EntityNotFoundException  {
    public CharacterCustomException(String message) {
        super(message);
    }

    public CharacterCustomException(int id) {
        super("Character doesnt exist with id: " + id);

    }

    public CharacterCustomException() {
        super("There are no actors");
    }
}
