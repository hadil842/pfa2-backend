package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.Demandebloquage;
import com.example.backend.service.Bolquercompteservice;



@CrossOrigin(origins = {"http://localhost:4200", "null", "http://localhost:9090"})
@RestController

public class Bloquagecontroler {

     private Bolquercompteservice bloqservice;
     

    public Bloquagecontroler(Bolquercompteservice bloqservice) {
        this.bloqservice = bloqservice;
    }
   @CrossOrigin
   @PostMapping("/bloquercompte")
   public ResponseEntity<?> bloquercompte (@RequestBody Demandebloquage bloc){

        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        int id_u = Integer.parseInt(userId);
         
        return ResponseEntity.ok(this.bloqservice.bloquercompte(bloc.getNumcompte(),id_u, bloc.getCodesecret(), bloc.getCause()));
   }
   @CrossOrigin
   @PostMapping("/debloquercompte")
   public ResponseEntity<?> debloquercompte (@RequestBody Demandebloquage bloc){
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        int id_u = Integer.parseInt(userId);

        return ResponseEntity.ok(this.bloqservice.debloquercompte(bloc.getNumcompte(),id_u, bloc.getCodesecret(), bloc.getCause()));
   }


}
