package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Services.Movie.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/Movies")
public class MovieController {
    private final MovieService movieService;


    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping("/getAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/getAll/character/{id}")
    public ResponseEntity findAllCharacterInMovie(@PathVariable int id){
        return ResponseEntity.ok(movieService.getCharacterMovie(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id){
        return ResponseEntity.ok(movieService.findById(id));
    }

    // doesn't create just check if the entity exist
    // check with nick tomorrow
    @PostMapping("/add")
    public ResponseEntity create(@RequestBody Movie movie) throws URISyntaxException {
        movieService.add(movie);
        URI uri = new URI("api/v1/movies/add/" + movie.getMovie_id());
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody Movie movieEntity, @PathVariable int id){
        if(id != movieEntity.getMovie_id()){
            return ResponseEntity.badRequest().build();
        }
        movieService.update(movieEntity);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updates/{id}")
    public ResponseEntity updateList(@PathVariable int id,@RequestBody int[] characters){
        movieService.updateCharacterInMovie(id,characters);
        return  ResponseEntity.noContent().build();
    }


}
