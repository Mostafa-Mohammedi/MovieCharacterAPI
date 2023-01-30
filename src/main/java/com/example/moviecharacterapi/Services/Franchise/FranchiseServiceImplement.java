package com.example.moviecharacterapi.Services.Franchise;

import com.example.moviecharacterapi.CustomException.FranchiseCustomException;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Repository.FranchiseRepository;
import com.example.moviecharacterapi.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FranchiseServiceImplement implements FranchiseService{

    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;

    public FranchiseServiceImplement(FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }
    @Override
    public Franchise findById(Integer integer) {
        return franchiseRepository.findById(integer).orElseThrow(() -> new FranchiseCustomException(integer));
    }

    @Override
    public Collection<Franchise> findAll() {
        if(franchiseRepository.findAll().size() != 0){
            return franchiseRepository.findAll();
        }
        else{
            throw new FranchiseCustomException();
        }
    }

    @Override
    public Franchise add(Franchise entity) {
        List<Franchise> franchiseList = franchiseRepository.findAll();
        for ( Franchise franchise: franchiseList) {
            if(entity.getName().equals(franchise.getName())){
                return franchiseRepository.save(entity);
            }

        }
        throw new FranchiseCustomException("Franchise already exist ");
    }
    @Override
    public Franchise update(Franchise entity) {

        List<Franchise> franchiseList = franchiseRepository.findAll();

        for ( Franchise franchise: franchiseList) {
            if(entity.getFranchise_id() == franchise.getFranchise_id())
                return franchiseRepository.save(entity);
        }
        throw  new FranchiseCustomException("movie doesnt exist, cannot update");
    }

    @Override
    public void deleteById(Integer integer) {

        var franchiseDelete = franchiseRepository.findById(integer).orElseThrow(()-> new FranchiseCustomException(integer));
        franchiseRepository.deleteById(franchiseDelete.getFranchise_id());
    }

    @Override
    public void updateMoviesInFranchise(int franchiseId, int[] listmovieId) {
        Franchise franchise = franchiseRepository.findById(franchiseId).get();
        Set<Movie> movieList = new HashSet<>();

        for (int id: listmovieId) {
            movieList.add(movieRepository.findById(id).get());
        }

        franchise.setMovies(movieList);
        franchiseRepository.save(franchise);

    }

    @Override
    public Collection<Movie> getAllMoviesInfranchise(int franchiseId) {
        return franchiseRepository.findById(franchiseId).get().getMovies();
    }
}
