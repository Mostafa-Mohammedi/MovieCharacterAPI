package com.example.moviecharacterapi.Repository;

import com.example.moviecharacterapi.Models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Collection;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

}
