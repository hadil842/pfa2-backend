package com.example.backend.controller;


import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.Recordreponse;
import com.example.backend.DTO.Tableaureponse;

import com.example.backend.entity.Client;
import com.example.backend.entity.Compte;
import com.example.backend.service.Clientservice;
import com.example.backend.service.Compteservice;
import com.example.backend.service.JWTservice;
import com.example.backend.service.Transactionservice;

import jakarta.servlet.http.HttpServletRequest;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TableauBordclient {

     private Compteservice compteservice;
     private Clientservice clientservice;
     private JWTservice jwTservice;
     private Transactionservice transactionservice;

    public TableauBordclient(Compteservice compteservice, Clientservice clientservice, JWTservice jwTservice,Transactionservice transactionservice) {
        this.compteservice = compteservice;
        this.clientservice = clientservice;
        this.jwTservice = jwTservice;
        this.transactionservice=transactionservice;
    }

    @CrossOrigin
    @PostMapping("/tableau-bord-donnes")
    public ResponseEntity<?> getDonnes(HttpServletRequest  request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring(7);

        if(token.equals(""))ResponseEntity.badRequest();
     System.out.println(token);
         int id_u=this.jwTservice.extractid_u(token);
         Client cl=this.clientservice.getClient(id_u);
         int id_cp=this.compteservice.getIdcompte(cl);

         
        return ResponseEntity.ok(new Tableaureponse(this.clientservice.getNomComplet(id_u),
        String.valueOf(this.compteservice.getSolde(cl)),
        String.valueOf(this.compteservice.getNumerocompte(cl)),this.compteservice.gettype(id_cp)));
    
    }
    
    @CrossOrigin
    @PostMapping("/tableau-bord-transactions")
    public ResponseEntity<?>getTransactions(HttpServletRequest  request){

         String authorizationHeader = request.getHeader("Authorization");
         String token = authorizationHeader.substring(7);
         if(token.equals(""))ResponseEntity.badRequest();

         int id_u=Integer.parseInt(this.jwTservice.getSubjectFromToken(token));
         Client cl=this.clientservice.getClient(id_u);
         int id_cp=this.compteservice.getIdcompte(cl);
         Compte compte=this.compteservice.getCompte(id_cp);

         return ResponseEntity.ok(this.transactionservice.getList(compte));
         
    }


    @CrossOrigin
    @PostMapping("/courbe-transactions")
    public ResponseEntity<List<Recordreponse>>getCourbe(HttpServletRequest  request){

         String authorizationHeader = request.getHeader("Authorization");
         String token = authorizationHeader.substring(7);

         if(token.equals(""))ResponseEntity.badRequest();

        int id_u=Integer.parseInt(this.jwTservice.getSubjectFromToken(token));
         Client cl=this.clientservice.getClient(id_u);
         int id_cp=this.compteservice.getIdcompte(cl);
         Compte compte=this.compteservice.getCompte(id_cp);
         List<Recordreponse>resultat=this.transactionservice.getRecord(compte);
         
         return ResponseEntity.ok(resultat);
    }  
        
    }
    


