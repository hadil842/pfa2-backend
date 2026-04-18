package com.example.backend.entity;



public class Transactionsreponse {
    private String date ;
    private String statut;
    private String localisation;
    
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

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

   
    private String montant ;

    public String getMontatnt() {
        return montant;
    }

    public void setMontatnt(String montatnt) {
        this.montant = montatnt;
    }

    public Transactionsreponse(String date, String type, String montatnt,String statut,String localisation) {
        this.date = date;
        this.type = type;
        this.localisation=localisation;
        this.montant = montatnt;
        this.statut=statut;
    }

}
