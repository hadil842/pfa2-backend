package com.example.backend.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Compte;
import com.example.backend.entity.Bd.Depot_espece;


@Repository

public interface Depot_especerepository extends ListCrudRepository<Depot_espece, Integer> {
    
      Depot_espece findById(int id_tr);


      List<Depot_espece>findByCompteOrderByDateheureAsc(Compte compte);
}
