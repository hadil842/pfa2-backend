package com.example.backend.DTO;

import java.math.BigDecimal;

public class Virementrequest {
    private long source;
    private long destination;
    private BigDecimal montant;
    private String nom;
    private int codesecret;

    public Virementrequest(long source, long destination, BigDecimal montant, String nom, int codesecret) {
        this.source = source;
        this.destination = destination;
        this.montant = montant;
        this.nom = nom;
        this.codesecret = codesecret;
    }

    public int getCodesecret() {
        return codesecret;
    }

    public void setCodesecret(int codesecret) {
        this.codesecret = codesecret;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getSource() {
        return source;
    }

    public void setSource(long source) {
        this.source = source;
    }

    public long getDestination() {
        return destination;
    }

    public void setDestination(long destination) {
        this.destination = destination;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Virementrequest() {
    }
}
