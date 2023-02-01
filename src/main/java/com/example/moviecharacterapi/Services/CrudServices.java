package com.example.moviecharacterapi.Services;

import java.util.Collection;

public interface CrudServices <T, ID> {

    // crud operation
    T findById(ID id);
    Collection<T> findAll();
    T add(T entity);
    T update(T entity);
    void deleteById(ID id);


}
