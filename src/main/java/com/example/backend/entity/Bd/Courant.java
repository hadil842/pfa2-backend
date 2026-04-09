package com.example.backend.entity.Bd;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="courant")
public class Courant extends Compte{
    public Courant(){
        super();
    }
    Courant(int numcompte,Date date_creation, BigDecimal solde,String etat,int  code_secret_compte,Client client){
        super(numcompte,date_creation,solde,etat,code_secret_compte,client);
    }
    
}
