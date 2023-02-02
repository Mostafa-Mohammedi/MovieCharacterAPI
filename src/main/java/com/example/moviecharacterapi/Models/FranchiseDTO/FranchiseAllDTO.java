package com.example.moviecharacterapi.Models.FranchiseDTO;

import lombok.Data;

import java.util.Set;



/**
 * Method for getting character without the relationship
 */

@Data
public class FranchiseAllDTO {

    private int id;
    private String name;
    private String description;
    private Set<Integer> movies;


}
