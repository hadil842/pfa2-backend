package com.example.backend.entity;

public class Demandebloquage {
    
    int codesecret;
    int idcp;
    String cause;
    
    public String getCause() {
        return cause;
    }
    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getId_cp() {
        return idcp;
    }
    public void setId_cp(int id_cp) {
        this.idcp = id_cp;
    }
    public int getCodesecret() {
        return codesecret;
    }
    public void setCodesecret(int codesecret) {
        this.codesecret = codesecret;
    }
    
    public Demandebloquage(String cause, int codesecret, int id_cp) {
        this.cause = cause;
        this.codesecret = codesecret;
        this.idcp = id_cp;
    }

}
