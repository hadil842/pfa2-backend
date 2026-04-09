package com.example.backend.entity;

import jakarta.persistence.Entity;


import jakarta.persistence.Table;

@Entity
@Table(name="administrateur")
public class Administateur extends Utilisateur{

    private String grade; 
    private int code_secret_admin; 

    Administateur(int id, String name, String password, String mail, String grade , int secretcode) {
        super(id, name, password, mail);
        this.grade=grade; 
        this.code_secret_admin=secretcode; 
    }

    public int getSecretCode (){ return this.code_secret_admin;}
    public void setSecretcode (int secretcode){ this.code_secret_admin=secretcode;}
    public String getGrade (){ return this.grade;}
    public void setGrade (String grade){ this.grade=grade;}
}
