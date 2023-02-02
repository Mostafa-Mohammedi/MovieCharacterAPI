package com.example.moviecharacterapi.Models.CharacterDTO;

import lombok.Data;

import java.util.Set;

/**
 * DTO class for getting all the characters fields including the relationship
 *
 */
@Data
public class CharacterAllDTO {
    private int id;
    private String fullname;

    private String alias;

    private String gender;

    private String picture;

    private Set<Integer> movies;

}
