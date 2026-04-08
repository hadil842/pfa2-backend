package com.example.backend.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_U;

    private String nomaccess;
    private String mot_de_passe;
    private String email;

    private Date date_naiss ;
    private int numer_tel ;
    private String nom_complet ; 
    private String etat_civil ;  


    User(int id,String name,String password,String mail){
        this.id_U=id;
        this.nomaccess=name;
        this.mot_de_passe=password;
        this.email=mail;
    }
    public int getId(){return this.id_U;}
    public String getAccessname(){return this.nomaccess;}
    public String getPassword(){return this.mot_de_passe;}
    public String getEmail(){return this.email;}
    public String getFullname(){return this.nom_complet;}

    public void setId(int ent){this.id_U=ent;}
    public void setAccessname(String nom){this.nomaccess=nom;}
    public void setPassword(String password){this.mot_de_passe=password;}
    public void setEmail(String mail){ this.email=mail;}


}
