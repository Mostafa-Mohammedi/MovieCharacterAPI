package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Mapper.CharacterMapper;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.CharacterDTO.CharacterDTO;
import com.example.moviecharacterapi.Services.Character.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/Characters")
public class CharacterController {
    private final CharacterService characterService;
    private CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }


    @GetMapping("/getAll")
    public ResponseEntity findAllCharacter(){
        return ResponseEntity.ok(characterMapper.listMovieDTO(characterService.findAll()));
    }
    @GetMapping("/{id}")
    public ResponseEntity findCharacterById(@PathVariable int id){
        return ResponseEntity.ok(characterMapper.characterDTO(characterService.findById(id)));
    }
    @PostMapping("/add")
    public ResponseEntity createCharacter(@RequestBody Character character) throws URISyntaxException {
        characterService.add(character);
        URI uri = new URI("api/v1/character/add/" + character.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCharacter(@RequestBody CharacterDTO character, @PathVariable int id){
        if(id != character.getId()){
            return ResponseEntity.badRequest().build();
        }
        characterService.update(characterMapper.updateCharater(character));
        return ResponseEntity.noContent().build();
    }





}
