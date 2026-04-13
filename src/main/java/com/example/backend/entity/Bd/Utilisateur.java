package com.example.backend.entity.Bd;

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
    private int id_u;

    private String nomaccess;
    private String motdepasse;
    private String email;

    private Date datenaiss ;
    private String numertel ;
    private String nomcomplet ; 
    private String etatcivil ;  

    public Utilisateur(){}
    
    Utilisateur(String name,String password,String mail,Date date_naiss ,String numer_tel,String nom_complet,String etat_civil ){
        this.nomaccess=name;
        this.motdepasse=password;
        this.email=mail;
        this.datenaiss=date_naiss;
        this.numertel=numer_tel;
        this.nomcomplet=nom_complet;
        this.etatcivil=etat_civil;
    }
    public int getId(){return this.id_u;}
    public String getAccessname(){return this.nomaccess;}
    public String getPassword(){return this.motdepasse;}
    public String getEmail(){return this.email;}
    public String getFullname(){return this.nomcomplet;}

    public void setId(int ent){this.id_u=ent;}
    public void setAccessname(String nom){this.nomaccess=nom;}
    public void setPassword(String password){this.motdepasse=password;}
    public void setEmail(String mail){ this.email=mail;}


}
