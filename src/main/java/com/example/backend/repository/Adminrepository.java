package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Administrateur;


@Repository
public interface Adminrepository extends CrudRepository<Administrateur, Integer> {
    
}