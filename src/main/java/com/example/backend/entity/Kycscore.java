package com.example.backend.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="kycscore")
public class Kycscore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idkysc;

    public Kycscore() {
    }

    private int valeur;
    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    private Date datecalcul;
    public Date getDatecalcul() {
        return datecalcul;
    }

    public void setDatecalcul(Date datecalcul) {
        this.datecalcul = datecalcul;
    }

    private Date dateprochaine;

    public Date getDateprochaine() {
        return dateprochaine;
    }

    public void setDateprochaine(Date dateprochaine) {
        this.dateprochaine = dateprochaine;
    }

    public Kycscore(int idkysc, int valeur, Date datecalcul, Date dateprochaine, Client client) {
        this.idkysc = idkysc;
        this.valeur = valeur;
        this.datecalcul = datecalcul;
        this.dateprochaine = dateprochaine;
        this.client = client;
    }

    @OneToOne
    @JoinColumn(name="idclient")
    private Client client;

   
 

}
