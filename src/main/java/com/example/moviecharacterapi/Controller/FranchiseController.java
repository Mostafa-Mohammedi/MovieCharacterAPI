package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Services.Franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/Franchise")
public class FranchiseController {
    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping("/getAll")
    public ResponseEntity findAllFranchise(){
        return ResponseEntity.ok(franchiseService.findAll());
    }

    @GetMapping("/getAll/movies/{id}")
    public ResponseEntity findAllCharacterInMovie(@PathVariable int id){
        return ResponseEntity.ok(franchiseService.getAllMoviesInfranchise(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity findfranchiseById(@PathVariable int id){
        return ResponseEntity.ok(franchiseService.findById(id));
    }
    @PostMapping("/add")
    public ResponseEntity createCharacter(@RequestBody Franchise franchise) throws URISyntaxException {
        franchiseService.add(franchise);
        URI uri = new URI("api/v1/character/add/" + franchise.getFranchise_id());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCharacter(@RequestBody Franchise franchise, @PathVariable int id){
        if(id != franchise.getFranchise_id()){
            return ResponseEntity.badRequest().build();
        }
        franchiseService.update(franchise);
        return ResponseEntity.noContent().build();
    }

}
