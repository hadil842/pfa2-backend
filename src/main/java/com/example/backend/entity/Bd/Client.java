package com.example.backend.entity.Bd;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Client extends Utilisateur{

    String profession; 
    BigDecimal salaire; 

    public Client(){super();}

    Client( String name,String password,String mail,Date date_naiss ,int numer_tel,String nom_complet,String etat_civil,String profession,BigDecimal salary  ) {
        super(name,password,mail,date_naiss,numer_tel,nom_complet,etat_civil);
        this.profession = profession; 
        this.salaire=salary; 
    }

    public BigDecimal getSalary (){ return this.salaire;}
    public void setSalary (BigDecimal salaire){ this.salaire=salaire;}

    public String getProfession (){ return this.profession;}
    public void setProfession (String profession){ this.profession=profession;}
}
