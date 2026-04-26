package com.example.backend.DTO;

public class Virementrequest {

    private String numdestination;
    private String montant;
    private String nomrecep;
    private String codesecret;

    public Virementrequest( String numdestination, String montant, String nom, String codesecret) {
        this.numdestination = numdestination;
        this.montant = montant;
        this.nomrecep = nom;
        this.codesecret = codesecret;
    }

    public String getCodesecret() {
        return codesecret;
    }

    public void setCodesecret(String codesecret) {
        this.codesecret = codesecret;
    }

    public String getNom() {
        return nomrecep;
    }

    public void setNom(String nom) {
        this.nomrecep = nom;
    }

    

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getNumdestination() {
        return numdestination;
    }

    public void setNumdestination(String numdestination) {
        this.numdestination = numdestination;
    }
}
