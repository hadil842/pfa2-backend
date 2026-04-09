package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Courant;


@Repository
public interface Courantrepository extends CrudRepository<Courant, Integer>{
    
}