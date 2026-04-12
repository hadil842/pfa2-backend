package com.example.backend.service;


import org.springframework.stereotype.Service;

import com.example.backend.repository.Utilisateurrepository;

@Service
public class Clientservice {
     
    public Utilisateurrepository utilisateurrepository;

    
    Clientservice(Utilisateurrepository utilisateurrepository) {
        this.utilisateurrepository = utilisateurrepository;
    }
   public  String getNomComplet(int id_u){
       return this.utilisateurrepository.findById(id_u).getFullname();
    }
}
