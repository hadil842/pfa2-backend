package com.example.backend.entity;

public class Acceilreponse {
    private String numerocompte;
    private String type_tr;
    private String solde;
    private String date;
    private String statut;

    public Acceilreponse(String numerocompte, String type_tr, String solde, String date, String statut) {
        this.numerocompte = numerocompte;
        this.type_tr = type_tr;
        this.solde = solde;
        this.date = date;
        this.statut = statut;
    }

    public String getNumerocompte() {
        return numerocompte;
    }

    public void setNumerocompte(String numerocompte) {
        this.numerocompte = numerocompte;
    }

    public String getType_cp() {
        return type_tr;
    }

    public void setType_cp(String type_cp) {
        this.type_tr = type_cp;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

}
