package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Alerte;

@Repository
public interface Alerterepository extends CrudRepository<Alerte, Integer>{
    
}
