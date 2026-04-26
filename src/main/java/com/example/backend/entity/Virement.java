package com.example.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="virement")

public class Virement extends Transactions{

   private long numcompterece;
   private String nomrece;

    
    public Virement( Date date_heure, BigDecimal montant, String localisation, String marchandcateg,String statut, String nom_rece, long  num_copmte_erce,Compte compte) {
        super( date_heure, montant, localisation,marchandcateg, statut,compte);
        this.nomrece = nom_rece;
        this.numcompterece = num_copmte_erce;
    }


    public long getNum_copmte_erce() {
        return numcompterece;
    }
    public String getNom_rece() {
        return nomrece;
    }
    public void setNum_copmte_erce(int num_copmte_erce) {
        this.numcompterece = num_copmte_erce;
    }
    public void setNom_rece(String nom_rece) {
        this.nomrece = nom_rece;
    }

}
