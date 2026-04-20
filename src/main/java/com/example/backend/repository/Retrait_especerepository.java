package com.example.backend.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Compte;
import com.example.backend.entity.Retrait_espece;


@Repository

public interface Retrait_especerepository extends ListCrudRepository<Retrait_espece, Integer> {
     
    Retrait_espece findById(int id_tr);



    List<Retrait_espece>findByCompteOrderByDateheureAsc(Compte compte);
} 
