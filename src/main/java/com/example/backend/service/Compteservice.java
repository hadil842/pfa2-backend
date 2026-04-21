package com.example.backend.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Client;
import com.example.backend.entity.Compte;
import com.example.backend.repository.Clientrepository;
import com.example.backend.repository.Compterepository;
import com.example.backend.repository.Courantrepository;


@Service
public class Compteservice {

    public Compterepository compterepo;
    public Courantrepository couranterepo;
    public Clientrepository clientrepository;
    


    
    public Compteservice(Compterepository compterepo, Courantrepository couranterepo,
            Clientrepository clientrepository) {
        this.compterepo = compterepo;
        this.couranterepo = couranterepo;
        this.clientrepository = clientrepository;
    }
   
    public Integer getIdcompte(Client cl){
        return this.compterepo.findByClient(cl).getId_cp();
    }
    public long getNumerocompte(Client cl){
        return this.compterepo.findByClient(cl).getNumcompte();
    }
    public BigDecimal getSolde(Client cl){
        return this.compterepo.findByClient(cl).getSolde();
    }
    public String gettype(int id_cp){
        return this.couranterepo.existsById(id_cp)? "Courant":"Epargne";
    }
    public Compte getCompte(int id_cp){
        return this.compterepo.findById(id_cp);
    }
}
