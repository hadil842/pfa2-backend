package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Compte;


@Repository
public interface Compterepository extends CrudRepository<Compte, Integer>{
    
}
