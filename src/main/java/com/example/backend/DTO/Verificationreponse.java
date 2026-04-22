package com.example.backend.DTO;

public class Verificationreponse {


    private String statut;
    public Verificationreponse(String statut) {
        this.statut = statut;
    }
    public Verificationreponse(String statut, String jwt) {
        this.statut = statut;
        this.jwt = jwt;
    }
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    private String jwt;
    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

}
