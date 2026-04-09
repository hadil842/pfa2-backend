package com.example.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="compte")

public class Compte {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_cp;
    private int numcompte;
    private Date date_creation;
    private BigDecimal solde; 
    private String etat;
    private int  code_secret_compte;
    @ManyToOne
    @JoinColumn(name="id_U")
    private Client client;
    public Compte(){}
    
    Compte(int numcompte,Date date_creation, BigDecimal solde,String etat,int  code_secret_compte,Client client){
        this.numcompte=numcompte;
        this.date_creation=date_creation;
        this.solde=solde;
        this.etat=etat;
        this.code_secret_compte=code_secret_compte;
        this.client=client;
    }

    public int getId_cp() {
        return id_cp;
    }

    public int getNumcompte() {
        return numcompte;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public String getEtat() {
        return etat;
    }

    public int getCode_secret_compte() {
        return code_secret_compte;
    }

    public Client getClient() {
        return client;
    }

    public void setId_cp(int id_cp) {
        this.id_cp = id_cp;
    }

    public void setNumcompte(int numcompte) {
        this.numcompte = numcompte;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setCode_secret_compte(int code_secret_compte) {
        this.code_secret_compte = code_secret_compte;
    }

    public void setId_U(Client client) {
        this.client=client;
    }
}

    