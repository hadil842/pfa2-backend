package com.example.backend.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.backend.repository.Clientrepository;
import com.example.backend.repository.Compterepository;
import com.example.backend.repository.Courantrepository;
import com.example.backend.repository.Epargnerepository;


@Service
public class Compteservice {

    public Compterepository compterepo;
    public Courantrepository couranterepo;
    public Epargnerepository epargnerepo;
    public Clientrepository clientrepository;
    


    
    public Compteservice(Compterepository compterepo, Courantrepository couranterepo, Epargnerepository epargnerepo,
            Clientrepository clientrepository) {
        this.compterepo = compterepo;
        this.couranterepo = couranterepo;
        this.epargnerepo = epargnerepo;
        this.clientrepository = clientrepository;
    }
   
    public Integer getIdcompte(int id_u){
        return this.compterepo.findByClient(this.clientrepository.findById(id_u)).getId_cp();
    }
    public long getNumerocompte(int id_u){
        return this.compterepo.findByClient(this.clientrepository.findById(id_u)).getNumcompte();
    }
    public BigDecimal getSolde(int id_u){
        return this.compterepo.findByClient(this.clientrepository.findById(id_u)).getSolde();
    }
    public String gettype(int id_cp){
        return this.couranterepo.findById(id_cp)!=null ? "Courant":"Epargne";
    }
}
