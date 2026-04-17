package com.example.backend.repository;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Client;
import com.example.backend.entity.Bd.Compte;




@Repository
public interface Compterepository extends ListCrudRepository<Compte, Integer>{
      
    Compte findByClient(Client cl);

    Compte findById(int id_cp);

    Compte findByNumcompte(long numcompte);
}
