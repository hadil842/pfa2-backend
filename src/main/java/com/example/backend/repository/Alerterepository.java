package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Alerte;

@Repository
public interface Alerterepository extends ListCrudRepository<Alerte, Integer>{
    
}
