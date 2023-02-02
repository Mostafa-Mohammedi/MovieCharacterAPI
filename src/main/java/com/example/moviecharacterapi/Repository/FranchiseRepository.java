package com.example.moviecharacterapi.Repository;

import com.example.moviecharacterapi.Models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The franchise JPA repository is in charge of the franchise crud operation
 */
@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {




}
