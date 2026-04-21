package com.example.backend.entity;

import java.util.Date;

import jakarta.persistence.Column;
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
    private int idu;

    private String nomaccess;
    private String motdepasse;

    @Column(nullable = false, unique = true)
    private String email;
    private String verificationToken;
    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }
    @Column(nullable = false)
    private boolean enabled;


    private Date datenaiss ;
    private String numertel ;
    private String nomcomplet ; 
    private String etatcivil ;
    private Integer scorecredit;  

    public Integer getScorecredit() {
        return scorecredit;
    }

    public void setScorecredit(Integer scorecredit) {
        this.scorecredit = scorecredit;
    }

    public Utilisateur(){}
    
    Utilisateur(String name,String password,String mail,Date date_naiss ,String numer_tel,String nom_complet,String etat_civil ,int sc){
        this.nomaccess=name;
        this.motdepasse=password;
        this.email=mail;
        this.datenaiss=date_naiss;
        this.numertel=numer_tel;
        this.nomcomplet=nom_complet;
        this.etatcivil=etat_civil;
        this.scorecredit=sc;
    }

    public int getId(){return this.idu;}
    public String getAccessname(){return this.nomaccess;}
    public String getPassword(){return this.motdepasse;}
    public String getEmail(){return this.email;}
    public String getFullname(){return this.nomcomplet;}

    public void setId(int ent){this.idu=ent;}
    public void setAccessname(String nom){this.nomaccess=nom;}
    public void setPassword(String password){this.motdepasse=password;}
    public void setEmail(String mail){ this.email=mail;}


}
