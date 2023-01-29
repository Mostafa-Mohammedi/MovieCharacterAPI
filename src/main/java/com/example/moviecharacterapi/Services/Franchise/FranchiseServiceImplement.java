package com.example.moviecharacterapi.Services.Franchise;

import com.example.moviecharacterapi.CustomException.FranchiseCustomException;
import com.example.moviecharacterapi.CustomException.MovieCustomException;
import com.example.moviecharacterapi.Models.Franchise;
import com.example.moviecharacterapi.Models.Movie;
import com.example.moviecharacterapi.Repository.FranchiseRepository;

import java.util.Collection;
import java.util.List;

public class FranchiseServiceImplement implements FranchiseService{

    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImplement(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
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
            if(!franchiseRepository.findFranchiseByName(entity.getName()).equals(franchise.getName())){
                return franchiseRepository.save(entity);
            }
        }
        throw  new FranchiseCustomException("movie doesnt exist, cannot update");
    }

    @Override
    public void deleteById(Integer integer) {

        var franchiseDelete = franchiseRepository.findById(integer).orElseThrow(()-> new FranchiseCustomException(integer));
        franchiseRepository.deleteById(franchiseDelete.getFranchise_id());
    }

}
