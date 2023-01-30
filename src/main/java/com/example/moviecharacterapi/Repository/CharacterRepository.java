package com.example.moviecharacterapi.Repository;

import com.example.moviecharacterapi.Models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

}
