package com.example.backend.DTO;

public class Demandebloquage {
    
    int codesecret;
    long numcompte;
    String cause;
    
    public String getCause() {
        return cause;
    }
    public void setCause(String cause) {
        this.cause = cause;
    }

    public long getNumcompte() {
        return numcompte;   
    }

    public void setNumcompte(long numcompte) {
        this.numcompte = numcompte;
    }

    public int getCodesecret() {
        return codesecret;
    }
    
    public void setCodesecret(int codesecret) {
        this.codesecret = codesecret;
    }
    
    public Demandebloquage(String cause, int codesecret, long numcompte) {
        this.cause = cause;
        this.codesecret = codesecret;
        this.numcompte = numcompte;
    }

}
