package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.backend.entity.Utilisateur;

@Repository
public interface Utilisateurrepository extends CrudRepository<Utilisateur, Integer> {

}

