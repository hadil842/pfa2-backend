package com.example.backend.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Compte;
import com.example.backend.entity.Bd.Paiement;


@Repository

public interface Paiementrepository extends ListCrudRepository<Paiement, Integer> {
    
    Paiement findById(int id_tr);

    
    List<Paiement>findByCompteOrderByDateheureAsc(Compte compte);
}
