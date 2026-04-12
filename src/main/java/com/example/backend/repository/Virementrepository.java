package com.example.backend.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Compte;

import com.example.backend.entity.Bd.Virement;

@Repository

public interface Virementrepository extends ListCrudRepository<Virement, Integer> {
    
     Virement findById(int id_tr);



     List<Virement>findByCompteOrderByDateheureAsc(Compte compte);
}
