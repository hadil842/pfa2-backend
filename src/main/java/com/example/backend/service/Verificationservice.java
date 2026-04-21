package com.example.backend.service;

import java.time.LocalDateTime;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Code;
import com.example.backend.entity.Utilisateur;
import com.example.backend.repository.Coderepository;
import com.example.backend.repository.Utilisateurrepository;

@Service
public class Verificationservice {

    private Coderepository coderepo;
    private Utilisateurrepository utilirepo;

    

    public Verificationservice(Coderepository coderepo, Utilisateurrepository utilirepo) {
        this.coderepo = coderepo;
        this.utilirepo = utilirepo;
    }



    public int genererCode(int id_u){

        Random rand = new Random();

        int cd = rand.nextInt(1000,9999);

        Utilisateur utili=this.utilirepo.findById(id_u);

        Code code=new Code(cd, LocalDateTime.now().plusMinutes(15),utili);

        this.coderepo.save(code);

        return cd;

    }

    public boolean verifierCode(int id_u,int cd){

         Utilisateur utili=this.utilirepo.findById(id_u);

         Code code=this.coderepo.findByUtilisateur(utili);

         if(code.getCode()==cd)return true;
         else return false;

    }
         
} 
  