package com.example.backend.entity;


public class Tableaureponse {
    
    private String nomcomplet;
    private String solde;
    private String numerocompte;
    private String typecp;
    
    public Tableaureponse(String nomcomplet, String solde, String numerocompte,String typecp) {
        this.nomcomplet = nomcomplet;
        this.solde = solde;
        this.numerocompte = numerocompte;
        this.typecp=typecp;
    }

    public String getNomcomplet() {
        return nomcomplet;
    }

    public String getSolde() {
        return solde;
    }

    public String getNumerocompte() {
        return numerocompte;
    }

    public String getTypecp() {
        return typecp;
    }
}
