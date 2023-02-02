package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Mapper.CharacterMapper;
import com.example.moviecharacterapi.Mapper.FranchiseMapper;
import com.example.moviecharacterapi.Models.Character;
import com.example.moviecharacterapi.Models.FranchiseDTO.FranchiseDTO;
import com.example.moviecharacterapi.Models.FranchiseDTO.FranchiseAllDTO;
import com.example.moviecharacterapi.Models.MovieDTO.MovieDTO;
import com.example.moviecharacterapi.Services.Franchise.FranchiseService;
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
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/Franchise")
public class FranchiseController {
    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;
    private final CharacterMapper characterMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper, CharacterMapper characterMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
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
                                    array = @ArraySchema(schema = @Schema(implementation = FranchiseAllDTO.class)))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {
                            @Content(mediaType = "application(json",
                                    schema = @Schema( implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity findAllFranchise(){
        return ResponseEntity.ok(franchiseMapper.listFranchiseDTo(franchiseService.findAll()));
    }





    @GetMapping("/{id}")
    @Operation(summary = "Finds a franchise by Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode =  "200",
                    description = "Succeeded fetching",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = FranchiseDTO.class))
                    }),
            @ApiResponse(
                    responseCode =  "500",
                    description = "Movies doesnt exist with id: with supplied id",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity findfranchiseById(@PathVariable int id){
        return ResponseEntity.ok(franchiseMapper.franchiseDTO(franchiseService.findById(id)));
    }




     @Operation(summary = "Find all the movies from franchise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "found all the character",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MovieDTO.class)))
                    }),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProblemDetail.class))
                    }),
            @ApiResponse(
                    responseCode = "500",
                    description = "internal serverer error",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProblemDetail.class))
                    })
    })

    @GetMapping("Movies/{id}")
    public ResponseEntity findAllMovieInFranchiseById(@PathVariable int id){
        return ResponseEntity.ok(franchiseMapper.listMovieDTO(franchiseService.getAllMoviesInfranchise(id)));
    }

    @PostMapping
    public ResponseEntity createFranchise(@RequestBody FranchiseDTO franchise) throws URISyntaxException {
        franchiseService.add(franchiseMapper.createFranchise(franchise));
        URI uri = new URI("api/v1/character/add/" + franchise.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a franchise")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Update the movie",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity updateFranchise(@RequestBody FranchiseDTO franchise, @PathVariable int id){
        if(id != franchise.getId()){
            return ResponseEntity.badRequest().build();
        }
        franchiseService.update(franchiseMapper.updateFranchise(franchise));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete Franchise from database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "delet the franchise from database",
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
        franchiseService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/getAllCharacter/{franchise_Id}/{movie_Id}")
    public ResponseEntity<Collection<Character>> getAllCharacterFromFranchise(@PathVariable int franchise_Id, @PathVariable int movie_Id){

       return  ResponseEntity.ok(franchiseService.getAllCharacterFromFranchise(franchise_Id, movie_Id));


    }




}
