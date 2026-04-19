package com.example.backend.entity.Bd;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="paiement")

public class Paiement extends Transactions{
    String destination;
    
    public Paiement(){super();}
    
    Paiement( Date date_heure, BigDecimal montant, int duree, String localisation, String statut,int type_fr, String destination,BigDecimal dp) {
        super( date_heure, montant, duree, localisation, statut, type_fr,dp);
        this.destination = destination;}

    public String getDestination() {
        return destination;  } 
    public void setDestination(String destination) {
        this.destination = destination;
    }

}
