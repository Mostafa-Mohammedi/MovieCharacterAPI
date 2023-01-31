package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Mapper.MovieMapper;
import com.example.moviecharacterapi.Models.DTO.Movie.MovieGetDTO;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Services.Movie.MovieService;
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

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }
    @Operation(summary = "Gets all the movies in the database")
    @GetMapping("/getAll")
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
                                    array = @ArraySchema(schema =  @Schema(implementation = MovieGetDTO.class)))
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
        return ResponseEntity.ok(movieService.getCharacterMovie(id));
    }
    @GetMapping("/{id}")
    @Operation(summary = "Finds a movie entity by Id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode =  "200",
                    description = "Succeeded fetching",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieGetDTO.class))
                    }),
            @ApiResponse(
                    responseCode =  "500",
                    description = "Movie doesnt exist with id: with supplied id",
                    content = {
                            @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
                    })
    })
    public ResponseEntity findById(@PathVariable int id){

        return ResponseEntity.ok(movieMapper.movieGetDTO(
                movieService.findById(id)
        ));
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new movie entity")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieGetDTO.class))
                    })
    })
    public ResponseEntity create(@RequestBody Movie movie) throws URISyntaxException {
        movieService.add(movie);
        URI uri = new URI("api/v1/movies/add/" + movie.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update a movie entity")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "created",
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

    public ResponseEntity update(@RequestBody Movie movieEntity, @PathVariable int id){
        if(id != movieEntity.getId()){
            return ResponseEntity.badRequest().build();
        }
        movieService.update(movieEntity);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updates/{id}")
    @Operation(summary = "Update a list of movie entities")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "created",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MovieGetDTO.class)))
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
    public ResponseEntity updateList(@PathVariable int id,@RequestBody int[] characters){
        movieService.updateCharacterInMovie(id,characters);
        return  ResponseEntity.noContent().build();
    }


}
