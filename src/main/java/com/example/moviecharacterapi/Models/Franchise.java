package com.example.moviecharacterapi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Franchise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int franchise_id;
    @Column(name = "franchise_Name", length = 200)
    private String name;

    @Column(name = "franchise_Description", length = 500)
    private String franchiseDescription;




}
