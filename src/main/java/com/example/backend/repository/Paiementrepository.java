package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Paiement;

@Repository

public interface Paiementrepository extends ListCrudRepository<Paiement, Integer> {

}
