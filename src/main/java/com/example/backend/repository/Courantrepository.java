package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Courant;


@Repository
public interface Courantrepository extends ListCrudRepository<Courant, Integer>{
    
}