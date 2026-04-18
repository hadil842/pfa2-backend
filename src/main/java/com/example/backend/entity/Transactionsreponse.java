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

   
    private String montant ;

    public String getMontatnt() {
        return montant;
    }

    public void setMontatnt(String montatnt) {
        this.montant = montatnt;
    }

    public Transactionsreponse(String date, String type, String montatnt,String statut) {
        this.date = date;
        this.type = type;
       
        this.montant = montatnt;
        this.statut=statut;
    }

}
