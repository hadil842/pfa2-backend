package com.example.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="depot_espece")

public class Depot_espece extends Transactions {

    public Depot_espece(){super();}
    
    Depot_espece( Date date_heure, BigDecimal montant, String localisation,String marchandcateg, String statut) {
        super( date_heure, montant, localisation,marchandcateg, statut);}

}
