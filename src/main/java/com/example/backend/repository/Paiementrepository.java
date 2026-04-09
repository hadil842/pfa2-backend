package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Paiement;

@Repository

public interface Paiementrepository extends CrudRepository<Paiement, Integer> {

}
