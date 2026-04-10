package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Client;

@Repository
public interface Clientrepository extends ListCrudRepository<Client, Integer> {
    

    public Client findByNomaccess(String accessname);
}