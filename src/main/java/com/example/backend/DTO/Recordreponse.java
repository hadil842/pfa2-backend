package com.example.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Recordreponse {
     private Date date;
     public Date getDate() {
        return date;
    }

     public void setDate(Date date) {
         this.date = date;
     }

     private BigDecimal valeur;
     
     public BigDecimal getValeur() {
        return valeur;
    }

     public void setValeur(BigDecimal valeur) {
         this.valeur = valeur;
     }

     public Recordreponse(Date date, BigDecimal valeur) {
        this.date = date;
        this.valeur = valeur;
     }
}
