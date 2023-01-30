package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Services.Character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/Characters")
public class CharacterController {
    private final CharacterService characterService;


    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/getAll")
    public ResponseEntity findAllCharacter(){
        return ResponseEntity.ok(characterService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity findCharacterById(@PathVariable int id){
        return ResponseEntity.ok(characterService.findById(id));
    }
    @PostMapping("/add")
    public ResponseEntity createCharacter(@RequestBody Character character) throws URISyntaxException {
        characterService.add(character);
        URI uri = new URI("api/v1/character/add/" + character.getCharacter_Id());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCharacter(@RequestBody Character character, @PathVariable int id){
        if(id != character.getCharacter_Id()){
            return ResponseEntity.badRequest().build();
        }
        characterService.update(character);
        return ResponseEntity.noContent().build();
    }





}
