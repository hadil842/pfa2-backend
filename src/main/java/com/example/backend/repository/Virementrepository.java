package com.example.backend.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Compte;

import com.example.backend.entity.Virement;

@Repository

public interface Virementrepository extends ListCrudRepository<Virement, Integer> {
    
     Virement findById(int id_tr);



     List<Virement>findByCompteOrderByDateheureAsc(Compte compte);

     List<Virement>findByNumcompterece(int numero);

     boolean existsByNumcompterece(int numeor);
}
