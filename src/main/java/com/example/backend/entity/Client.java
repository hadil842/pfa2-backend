package com.example.backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Client extends Utilisateur{

    String profession; 
    BigDecimal salaire; 


    Client(int id, String name, String password, String mail,String profession,BigDecimal salary ) {
        super(id, name, password, mail);
        this.profession = profession; 
        this.salaire=salary; 
    }

    public BigDecimal getSalary (){ return this.salaire;}
    public void setSalary (BigDecimal salaire){ this.salaire=salaire;}

    public String getProfession (){ return this.profession;}
    public void setProfession (String profession){ this.profession=profession;}
}
