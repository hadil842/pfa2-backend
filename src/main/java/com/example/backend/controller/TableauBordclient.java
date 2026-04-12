package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Tableaureponse;
import com.example.backend.service.Clientservice;
import com.example.backend.service.Compteservice;
import com.example.backend.service.JWTservice;

import jakarta.servlet.http.HttpServletRequest;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TableauBordclient {

     private Compteservice compteservice;
     private Clientservice clientservice;
     private JWTservice jwTservice;

    public TableauBordclient(Compteservice compteservice, Clientservice clientservice, JWTservice jwTservice) {
        this.compteservice = compteservice;
        this.clientservice = clientservice;
        this.jwTservice = jwTservice;
    }

    @CrossOrigin
    @PostMapping("/tableau-bord-donnes")
    public ResponseEntity<?> getdonnes(HttpServletRequest  request) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring(7);


         
         int id_u=this.jwTservice.extractid_u(token);
         
         int id_cp=this.compteservice.getIdcompte(id_u);


        return ResponseEntity.ok(new Tableaureponse(this.clientservice.getNomComplet(id_u),
        String.valueOf(this.compteservice.getSolde(id_u)),String.valueOf(this.compteservice.getNumerocompte(id_u)),this.compteservice.gettype(id_cp)));
    
    }

   
        
    }
    


