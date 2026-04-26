package com.example.backend.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.VerificationVirement;
import com.example.backend.DTO.Virementrequest;


import com.example.backend.service.Virementservice;

@CrossOrigin(origins = { "http://localhost:4200", "null", "http://localhost:9090" })
@RestController
public class Virementcontroller {
    private Virementservice virementser;
  

    public Virementcontroller(Virementservice virementser) {
        this.virementser = virementser;
    }


    @CrossOrigin
    @PostMapping("/envoie-email-virement")
    public ResponseEntity<?> envoyer(@RequestBody Virementrequest vir) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        int id_u = Integer.parseInt(userId);

        virementser.preparerVirement(id_u,Long.parseLong(vir.getNumdestination()),new BigDecimal(vir.getMontant()),Integer.parseInt(vir.getCodesecret()),vir.getNom());
        return ResponseEntity.ok().body("Code envoyé par email");
    }

    @PostMapping("/confirmer-virement")
    public ResponseEntity<?> confirmer(@RequestBody VerificationVirement verif) {

       String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
       int id_u = Integer.parseInt(userId);

        String reponse=this.virementser.effectuerVirement(id_u,verif.getCode());
        return  ResponseEntity.ok().body(reponse);
    }
}
