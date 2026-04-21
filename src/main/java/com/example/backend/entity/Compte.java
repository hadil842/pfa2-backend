package com.example.backend.entity;

import java.math.BigDecimal;
import java.util.Date;

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
    private int idcp;

    private long numcompte;
    private Date datecreation;
    private BigDecimal solde; 
    private BigDecimal soldeinit; 
    private String causeblocage =" ";
    public String getCauseblocage() {
        return causeblocage;
    }

    public void setCauseblocage(String causeblocage) {
        this.causeblocage = causeblocage;
    }

    public BigDecimal getSolde_init() {
        return soldeinit;
    }

    public void setSolde_init(BigDecimal solde_init) {
        this.soldeinit = solde_init;
    }

    private String etat;
    private int  codesecretcompte;
    private BigDecimal depencemoy;

    public BigDecimal getDepencemoy() {
        return depencemoy;
    }

    public void setDepencemoy(BigDecimal depencemoy) {
        this.depencemoy = depencemoy;
    }

    @ManyToOne
    @JoinColumn(name="idu")
    private Client client;
    
    public Compte(){}
    
    Compte(long numcompte,Date date_creation, BigDecimal solde,String etat,int  code_secret_compte,Client client,BigDecimal s,BigDecimal dep){
        this.numcompte=numcompte;
        this.datecreation=date_creation;
        this.solde=solde;
        this.etat=etat;
        this.codesecretcompte=code_secret_compte;
        this.client=client;
        this.soldeinit=s;
        this.depencemoy=dep;
    }

    public int getId_cp() {
        return idcp;
    }

    public long getNumcompte() {
        return numcompte;
    }

    public Date getDate_creation() {
        return datecreation;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public String getEtat() {
        return etat;
    }

    public int getCode_secret_compte() {
        return codesecretcompte;
    }

    public Client getClient() {
        return client;
    }

    public void setId_cp(int id_cp) {
        this.idcp = id_cp;
    }

    public void setNumcompte(int numcompte) {
        this.numcompte = numcompte;
    }

    public void setDate_creation(Date date_creation) {
        this.datecreation = date_creation;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setCode_secret_compte(int code_secret_compte) {
        this.codesecretcompte = code_secret_compte;
    }

    public void setId_U(Client client) {
        this.client=client;
    }
}

    