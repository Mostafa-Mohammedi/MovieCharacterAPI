package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Mapper.CharacterMapper;
import com.example.moviecharacterapi.Mapper.MovieMapper;
import com.example.moviecharacterapi.Models.MovieDTO.MovieDTO;
import com.example.moviecharacterapi.Models.MovieDTO.MovieAllDTO;
import com.example.moviecharacterapi.Services.Movies.MovieService;
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
@RequestMapping(path = "api/v1/Movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final CharacterMapper characterMapper;
    public MovieController(MovieService movieService, MovieMapper movieMapper, CharacterMapper characterMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.characterMapper = characterMapper;
    }
    @GetMapping("/getAll")
    @Operation(summary = "Gets all the movies in the database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode =  "200",
                    description = "Succeeded fetching",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieAllDTO.class))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {
                            @Content(mediaType = "application(json",
                                    schema = @Schema( implementation = ProblemDetail.class))
                    })
    })

    public ResponseEntity findAll(){
        return ResponseEntity.ok(movieMapper.listMovieDTO(movieService.findAll()));
    }

    @GetMapping("/getAll/character/{id}")
    @Operation(summary = "Finds All character that played in the movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode =  "200",
                    description = "Succeeded fetching",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MovieAllDTO.class)))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = {
                            @Content(mediaType = "application(json",
                            schema = @Schema( implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity findAllCharacterInMovie(@PathVariable int id){
        return ResponseEntity.ok(characterMapper.listCharacter(movieService.getCharacterMovie(id)));
    }
    @GetMapping("/{id}")
    @Operation(summary = "Finds a movie entity by Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode =  "200",
                    description = "Succeeded fetching",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieAllDTO.class))
                    }),
            @ApiResponse(
                    responseCode =  "500",
                    description = "Movies doesnt exist with id: with supplied id",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity findById(@PathVariable int id){

        return ResponseEntity.ok(movieMapper.movieDTO(
                movieService.findById(id)
        ));
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new movie entity")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })
    public ResponseEntity create(@RequestBody MovieDTO movie) throws URISyntaxException {
        movieService.add(movieMapper.CreateMovie(movie));
        URI uri = new URI("api/v1/movies/add/" + movie.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a movie entity")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Update the movie",
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
    public ResponseEntity update(@RequestBody MovieDTO movieEntity, @PathVariable int id){
        if(id != movieEntity.getId()){
            return ResponseEntity.badRequest().build();
        }
        movieService.update(movieMapper.updateMovie(movieEntity));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete movie from database")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Update the movie",
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
        movieService.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping("/updates/{id}")
    @Operation(summary = "Update a list of movie entities")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "created",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "internal serverer error",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity updateList(@PathVariable int id,@RequestBody int[] characters){
        movieService.updateCharacterInMovie(id,characters);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/getCharacter/movie/{id}")
    public ResponseEntity getCharacterInMovies(@PathVariable int id){
        movieService.getCharacterMovie(id);
        return  ResponseEntity.ok(characterMapper.listCharacter(movieService.getCharacterMovie(id)));
    }

}
