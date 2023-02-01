package com.example.moviecharacterapi.Controller;
import com.example.moviecharacterapi.Mapper.FranchiseMapper;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.FranchiseDTO.UpdateFranchiseDTO;
import com.example.moviecharacterapi.Services.Franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "api/v1/Franchise")
public class FranchiseController {
    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }


    @GetMapping("/getAll")
    public ResponseEntity findAllFranchise(){
        return ResponseEntity.ok(franchiseMapper.listFranchiseDTo(franchiseService.findAll()));
    }

    @GetMapping("/getAll/movies/{id}")
    public ResponseEntity findAllCharacterInMovie(@PathVariable int id){
        return ResponseEntity.ok(franchiseService.getAllMoviesInfranchise(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity findfranchiseById(@PathVariable int id){
        return ResponseEntity.ok(franchiseMapper.franchiseDTO(franchiseService.findById(id)));
    }
    @PostMapping("/add")
    public ResponseEntity createCharacter(@RequestBody Franchise franchise) throws URISyntaxException {
        franchiseService.add(franchise);
        URI uri = new URI("api/v1/character/add/" + franchise.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateFranchise(@RequestBody UpdateFranchiseDTO franchise, @PathVariable int id){
        if(id != franchise.getId()){
            return ResponseEntity.badRequest().build();
        }
        franchiseService.update(franchiseMapper.updateFranchise(franchise));
        return ResponseEntity.noContent().build();
    }

}
