package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.Demandebloquage;
import com.example.backend.service.Bolquercompteservice;
import com.example.backend.service.JWTservice;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"http://localhost:4200", "null", "http://localhost:9090"})
@RestController

public class Bloquagecontroler {

     private Bolquercompteservice bloqservice;
     private JWTservice jwTservice;

    public Bloquagecontroler(Bolquercompteservice bloqservice, JWTservice jwTservice) {
        this.bloqservice = bloqservice;
        this.jwTservice = jwTservice;
    }

   @PostMapping("/bloquercompte")
   public ResponseEntity<?> bloquercompte (HttpServletRequest  request,@RequestBody Demandebloquage bloc){
    String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring(7);

        if(token.equals(""))ResponseEntity.badRequest();

         int id_u=Integer.parseInt(this.jwTservice.getSubjectFromToken(token));
         
         return ResponseEntity.ok(this.bloqservice.bloquercompte(bloc.getNumcompte(),id_u, bloc.getCodesecret(), bloc.getCause()));
   }

   @PostMapping("/debloquercompte")
   public ResponseEntity<?> debloquercompte (HttpServletRequest  request,@RequestBody Demandebloquage bloc){
    String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring(7);

        if(token.equals(""))ResponseEntity.badRequest();

         int id_u=Integer.parseInt(this.jwTservice.getSubjectFromToken(token));
         return ResponseEntity.ok(this.bloqservice.debloquercompte(bloc.getNumcompte(),id_u, bloc.getCodesecret(), bloc.getCause()));
   }


}
