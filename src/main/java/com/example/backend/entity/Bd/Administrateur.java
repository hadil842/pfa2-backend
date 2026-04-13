package com.example.backend.entity.Bd;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="administrateur")
public class Administrateur extends Utilisateur{

    private String grade; 
    private int codesecretadmin; 
    
    public Administrateur(){
        super();
    }

    Administrateur(String name,String password,String mail,Date date_naiss ,String numer_tel,String nom_complet,String etat_civil ,String grade,int secretcode) {
        super(name,password,mail,date_naiss,numer_tel,nom_complet,etat_civil);
        this.grade=grade; 
        this.codesecretadmin=secretcode; 
    }

    public int getSecretCode (){ return this.codesecretadmin;}
    public void setSecretcode (int secretcode){ this.codesecretadmin=secretcode;}
    public String getGrade (){ return this.grade;}
    public void setGrade (String grade){ this.grade=grade;}
}
