package com.example.backend.repository;


import org.springframework.data.repository.ListCrudRepository;

import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Utilisateur;



@Repository
public interface Utilisateurrepository extends ListCrudRepository<Utilisateur, Integer> {
    
    Utilisateur findById(int id);
    Utilisateur findByNomaccess(String nomaccess);
    Utilisateur findByVerificationToken(String token);
}  

