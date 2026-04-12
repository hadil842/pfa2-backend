package com.example.backend.repository;


import org.springframework.data.repository.ListCrudRepository;

import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Compte;
import com.example.backend.entity.Bd.Transactions;
import java.util.List;




@Repository

public interface Transactionsrepository extends ListCrudRepository<Transactions, Integer> {
     
    List<Transactions>findByCompte(Compte compte);
    
}
