package com.example.backend.entity;

public class Authreponse {

    private String JWT;

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
