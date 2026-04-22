package com.example.backend.DTO;

public class Authreponse {

    private int code;
    private int idu;
    public Authreponse(int code, int idu, String etat) {
        this.code = code;
        this.idu = idu;
        this.etat = etat;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private String etat;

    public Authreponse(int code, String etat) {
        this.code = code;
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Integer getCode() {
        return this.code;
    }

   
}
