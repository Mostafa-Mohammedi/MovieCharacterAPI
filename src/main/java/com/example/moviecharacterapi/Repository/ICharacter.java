package com.example.moviecharacterapi.Repository;

import com.example.moviecharacterapi.Models.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICharacter extends JpaRepository<Integer, Character> {


}
