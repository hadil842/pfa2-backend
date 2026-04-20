package com.example.backend.service;


import org.springframework.stereotype.Service;

import com.example.backend.entity.Client;
import com.example.backend.repository.Clientrepository;


@Service
public class Clientservice {
     
    public Clientrepository clientrepositoryrepository;

    
    Clientservice(Clientrepository utilisateurrepository) {
        this.clientrepositoryrepository = utilisateurrepository;
    }
    public  String getNomComplet(int id_u){
       return this.clientrepositoryrepository.findById(id_u).getFullname();
    }
    public Client getClient(int id_u){
        return this.clientrepositoryrepository.findById(id_u);
    }
}
