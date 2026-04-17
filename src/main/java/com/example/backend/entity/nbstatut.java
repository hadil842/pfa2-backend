package com.example.backend.entity;

public class nbstatut {
    private String solde;
    private String nbsucess;
    private String nbencours;
    private String nbrefu;

    public nbstatut(String solde, String nbsucess, String nbencours, String nbrefu) {
        this.solde = solde;
        this.nbsucess = nbsucess;
        this.nbencours = nbencours;
        this.nbrefu = nbrefu;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public String getNbsucess() {
        return nbsucess;
    }

    public void setNbsucess(String nbsucess) {
        this.nbsucess = nbsucess;
    }

    public String getNbencours() {
        return nbencours;
    }

    public void setNbencours(String nbencours) {
        this.nbencours = nbencours;
    }

    public String getNbrefu() {
        return nbrefu;
    }

    public void setNbrefu(String nbrefu) {
        this.nbrefu = nbrefu;
    }

}
