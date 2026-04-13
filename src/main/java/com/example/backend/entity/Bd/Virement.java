package com.example.backend.entity.Bd;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="virement")

public class Virement extends Transactions{

   private long numcompterece;
   private String nomrece;

    public Virement(){super();}
    Virement( Date date_heure, BigDecimal montant, int duree, String localisation, String statut,String type_fr, String nom_rece, int num_copmte_erce) {
        super( date_heure, montant, duree, localisation, statut, type_fr);
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
