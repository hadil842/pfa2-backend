package com.example.backend.entity;



public class Transactionsreponse {
    private String date ;
    private String statut;
    
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String type ;
    public String getType() {
        return type;
    }

    private String reference;
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    private String montant ;

    public String getMontatnt() {
        return montant;
    }

    public void setMontatnt(String montatnt) {
        this.montant = montatnt;
    }

    public Transactionsreponse(String date, String type, String reference, String montatnt,String statut) {
        this.date = date;
        this.type = type;
        this.reference = reference;
        this.montant = montatnt;
        this.statut=statut;
    }

}
