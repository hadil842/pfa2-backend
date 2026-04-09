package com.example.backend.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "utilisateur")
public class Utilisateur {
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

    public Utilisateur(){}
    
    Utilisateur(String name,String password,String mail,Date date_naiss ,int numer_tel,String nom_complet,String etat_civil ){
        this.nomaccess=name;
        this.mot_de_passe=password;
        this.email=mail;
        this.date_naiss=date_naiss;
        this.numer_tel=numer_tel;
        this.nom_complet=nom_complet;
        this.etat_civil=etat_civil;
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
