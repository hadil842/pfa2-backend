package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.entity.Client;

@Repository
public interface Clientrepository extends CrudRepository<Client, Integer> {
    
}