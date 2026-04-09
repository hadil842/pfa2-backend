package com.example.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="epargne")
public class Epargne extends Compte {
    private BigDecimal montant_mensuel;
    public Epargne(){
        super();
    }
    Epargne(int numcompte,Date date_creation, BigDecimal solde,String etat,int  code_secret_compte,Client client,BigDecimal montant_mensuel){
        super(numcompte,date_creation,solde,etat,code_secret_compte,client);
        this.montant_mensuel=montant_mensuel;
    }
    public BigDecimal getMontant_mensuel(){ return this.montant_mensuel;}
    public void setMontant_mensuel (BigDecimal montant_mensuel){ this.montant_mensuel=montant_mensuel;} 
}
