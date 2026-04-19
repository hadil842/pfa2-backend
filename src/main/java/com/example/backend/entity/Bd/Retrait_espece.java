package com.example.backend.entity.Bd;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="retrait_espece")   

public class Retrait_espece extends Transactions {

    public Retrait_espece(){super();}

    Retrait_espece( Date date_heure, BigDecimal montant, int duree, String localisation, String statut,int type_fr,BigDecimal dp) {
        super( date_heure, montant, duree, localisation, statut, type_fr,dp);} 
   
}
