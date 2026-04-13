package com.example.backend.entity;

public class Authreponse {

    private String JWT;
    private String etat;

    public Authreponse(String jWT, String etat) {
        JWT = jWT;
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String jWT) {
        JWT = jWT;
    }

    public Authreponse(String jWT) {
        JWT = jWT;
    }
}
