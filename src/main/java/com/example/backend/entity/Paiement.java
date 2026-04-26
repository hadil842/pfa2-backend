package com.example.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="paiement")

public class Paiement extends Transactions{
    String destination;
    
    public Paiement(){super();}
    
    Paiement( Date date_heure, BigDecimal montant, String localisation,String marchandcateg, String statut, String destination) {
        super( date_heure, montant, localisation,marchandcateg,statut);
        this.destination = destination;}

    public String getDestination() {
        return destination;  } 
    public void setDestination(String destination) {
        this.destination = destination;
    }

}
