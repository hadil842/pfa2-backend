package com.example.backend.controller;


import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.Recordreponse;
import com.example.backend.DTO.Tableaureponse;

import com.example.backend.entity.Client;
import com.example.backend.entity.Compte;
import com.example.backend.service.Clientservice;
import com.example.backend.service.Compteservice;
import com.example.backend.service.Transactionservice;






@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TableauBordclient {

     private Compteservice compteservice;
     private Clientservice clientservice;
     private Transactionservice transactionservice;

    public TableauBordclient(Compteservice compteservice, Clientservice clientservice,Transactionservice transactionservice) {
        this.compteservice = compteservice;
        this.clientservice = clientservice;
        this.transactionservice=transactionservice;
    }

    @CrossOrigin
    @PostMapping("/tableau-bord-donnes")
    public ResponseEntity<?> getDonnes() {

        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        int id_u = Integer.parseInt(userId);
        Client cl=this.clientservice.getClient(id_u);
        int id_cp=this.compteservice.getIdcompte(cl);

         
        return ResponseEntity.ok(new Tableaureponse(this.clientservice.getNomComplet(id_u),
        String.valueOf(this.compteservice.getSolde(cl)),
        String.valueOf(this.compteservice.getNumerocompte(cl)),this.compteservice.gettype(id_cp)));
    
    }
    
    @CrossOrigin
    @PostMapping("/tableau-bord-transactions")
    public ResponseEntity<?>getTransactions(){

         String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
         int id_u = Integer.parseInt(userId);

         Client cl=this.clientservice.getClient(id_u);
         int id_cp=this.compteservice.getIdcompte(cl);
         Compte compte=this.compteservice.getCompte(id_cp);

         return ResponseEntity.ok(this.transactionservice.getList(compte));
         
    }


    @CrossOrigin
    @PostMapping("/courbe-transactions")
    public ResponseEntity<List<Recordreponse>>getCourbe(){

         String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
         int id_u = Integer.parseInt(userId);

         Client cl=this.clientservice.getClient(id_u);
         int id_cp=this.compteservice.getIdcompte(cl);
         Compte compte=this.compteservice.getCompte(id_cp);
         List<Recordreponse>resultat=this.transactionservice.getRecord(compte);
         
         return ResponseEntity.ok(resultat);
    }  
        
    }
    


