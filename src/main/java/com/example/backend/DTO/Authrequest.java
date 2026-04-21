package com.example.backend.DTO;




public class Authrequest {
    private String nom;
    private String mdp;
    

    public Authrequest(String nom,String mdp){
        this.nom=nom;
        this.mdp=mdp;
    }
    public String getNom(){return this.nom;}
    public String getMdp(){return this.mdp;}



}
