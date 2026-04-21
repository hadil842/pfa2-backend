package com.example.backend.repository;


import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Code;
import com.example.backend.entity.Utilisateur;

@Repository
public interface Coderepository extends ListCrudRepository<Code,Integer>{
        
    Code save(Code code);

    Code findByUtilisateur(Utilisateur utili);
}
