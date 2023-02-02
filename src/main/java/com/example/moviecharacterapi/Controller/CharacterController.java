package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Mapper.CharacterMapper;
import com.example.moviecharacterapi.Models.CharacterDTO.CharacterAllDTO;
import com.example.moviecharacterapi.Models.CharacterDTO.CharacterDTO;
import com.example.moviecharacterapi.Services.Character.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/Characters")
public class CharacterController {

    private  final CharacterService characterService;
    private CharacterMapper characterMapper;




    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }



    @GetMapping("/getAll")
    @Operation(summary = "Gets all the Franchise in the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode =  "200",
                    description = "Succeeded fetching",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CharacterAllDTO.class)))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {
                            @Content(mediaType = "application(json",
                                    schema = @Schema( implementation = ProblemDetail.class))
                    })
    })

    public ResponseEntity findAllCharacter(){
        return ResponseEntity.ok(characterMapper.listCharacter(characterService.findAll()));
    }
    @GetMapping("/{id}")
    @PostMapping("/add")
    @Operation(summary = "add a new a franchise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CharacterDTO.class))
                    })
    })
    public ResponseEntity findCharacterById(@PathVariable int id){
        return ResponseEntity.ok(characterMapper.characterDTO(characterService.findById(id)));
    }
    @PostMapping("/add")
    @Operation(summary = "Adding a character to the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode =  "204",
                    description = "created",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CharacterDTO.class))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {
                            @Content(mediaType = "application(json",
                                    schema = @Schema( implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity createCharacter(@RequestBody CharacterDTO character) throws URISyntaxException {
        characterService.add(characterMapper.character(character));
        URI uri = new URI("api/v1/character/add/" + character.getId());
        return ResponseEntity.created(uri).build();
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "updating character")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode =  "204",
                    description = "created",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CharacterDTO.class))
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(mediaType = "application(json",
                                    schema = @Schema( implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity updateCharacter(@RequestBody CharacterDTO character, @PathVariable int id){
        if(id != character.getId()){
            return ResponseEntity.badRequest().build();
        }
        characterService.update(characterMapper.character(character));
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete character from database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "character deleted",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity deleteById(@PathVariable int id){
        characterService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }


}
