package com.example.backend.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.VerificationVirement;
import com.example.backend.DTO.Virementrequest;
import com.example.backend.repository.Compterepository;
import com.example.backend.service.JWTservice;
import com.example.backend.service.Virementservice;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = { "http://localhost:4200", "null", "http://localhost:9090" })
@RestController
public class Virementcontroller {
    private Virementservice virementser;
    private Compterepository compterepo;
    private JWTservice jwTservice;

    public Virementcontroller(Virementservice virementser, Compterepository compterepo, JWTservice jwTservice) {
        this.virementser = virementser;
        this.compterepo = compterepo;
        this.jwTservice = jwTservice;
    }


    @CrossOrigin
    @PostMapping("/envoie-email-virement")
    public ResponseEntity<?> envoyer(HttpServletRequest  request,@RequestBody Virementrequest vir) {
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring(7);

        if(token.equals(""))ResponseEntity.badRequest();

        int id_u=Integer.parseInt(this.jwTservice.getSubjectFromToken(token));

        virementser.preparerVirement(id_u,Long.parseLong(vir.getNumdestination()),new BigDecimal(vir.getMontant()),Integer.parseInt(vir.getCodesecret()),vir.getNom());
        return ResponseEntity.ok().body("Code envoyé par email");
    }

    @PostMapping("/confirmer-virement")
    public ResponseEntity<?> confirmer(HttpServletRequest  request,@RequestBody VerificationVirement verif) {

        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring(7);

        if(token.equals(""))ResponseEntity.badRequest();

        int id_u=Integer.parseInt(this.jwTservice.getSubjectFromToken(token));

        String reponse=this.virementser.effectuerVirement(id_u,verif.getCode());
        return  ResponseEntity.ok().body(reponse);
    }
}
