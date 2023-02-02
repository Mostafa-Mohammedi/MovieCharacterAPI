package com.example.moviecharacterapi.Models.FranchiseDTO;

import lombok.Data;


/**
 * DTO class for getting all the franchise fields excluding the relationship
 */
@Data
public class FranchiseDTO {
    private int id;
    private String name;
    private String description;
}
