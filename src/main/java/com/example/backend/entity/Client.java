package com.example.backend.entity;

import jakarta.persistence.Entity;


@Entity
public class Client extends User{

    String profession; 
    float salaire; 


    Client(int id, String name, String password, String mail,String profession,int salary ) {
        super(id, name, password, mail);
        this.profession = profession; 
        this.salaire=salary; 
    }

    public float getSalary (){ return this.salaire;}
    public void setSalary (float salaire){ this.salaire=salaire;}

    public String getProfession (){ return this.profession;}
    public void setProfession (String profession){ this.profession=profession;}
}
