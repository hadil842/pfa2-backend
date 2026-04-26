package com.example.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="retrait_espece")   

public class Retrait_espece extends Transactions {

    public Retrait_espece(){super();}

    Retrait_espece( Date date_heure, BigDecimal montant, String localisation,String marchandcateg,String statut) {
        super( date_heure, montant, localisation,marchandcateg,statut);} 
   
}
