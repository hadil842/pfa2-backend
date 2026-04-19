package com.example.backend.entity.Bd;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="depot_espece")

public class Depot_espece extends Transactions {

    public Depot_espece(){super();}
    
    Depot_espece( Date date_heure, BigDecimal montant, int duree, String localisation, String statut,int type_fr,BigDecimal dp) {
        super( date_heure, montant, duree, localisation, statut, type_fr,dp);}

}
