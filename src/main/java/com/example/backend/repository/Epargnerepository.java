package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Epargne;

@Repository
public interface Epargnerepository extends ListCrudRepository<Epargne, Integer> {
    
}
