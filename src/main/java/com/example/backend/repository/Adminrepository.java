package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Administrateur;


@Repository
public interface Adminrepository extends ListCrudRepository<Administrateur, Integer> {
    
}