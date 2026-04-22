package com.example.backend.DTO;

public class Authreponse {

   
    private int idu;
    public Authreponse(int idu) {
        this.idu = idu;
    }

    public Authreponse(int idu, String etat) {
        this.idu = idu;
        this.etat = etat;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

   
    private String etat;

    

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    

   
}
