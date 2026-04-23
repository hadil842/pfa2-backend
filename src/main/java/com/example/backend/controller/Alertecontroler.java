package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.Alerterequest;
import com.example.backend.DTO.Demandebloquage;
import com.example.backend.service.Alertesendservice;
import com.example.backend.service.EmailService;
import com.example.backend.service.JWTservice;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"http://localhost:4200", "null", "http://localhost:9090"})
@RestController

public class Alertecontroler {
    private JWTservice jwtserv;
    private Alertesendservice alerteserv;
    private EmailService emailServ;

    public Alertecontroler(JWTservice jwtserv, Alertesendservice alerteserv, EmailService emailServ) {
        this.jwtserv = jwtserv;
        this.alerteserv = alerteserv;
        this.emailServ = emailServ;
    }

@CrossOrigin
@PostMapping("/alerte")
 public ResponseEntity<?> envoyeralerte (HttpServletRequest  request,@RequestBody Alerterequest alerte){

        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring(7);

        if(token.equals(""))ResponseEntity.badRequest();

         int id_u=Integer.parseInt(this.jwtserv.getSubjectFromToken(token));
         this.emailServ.sendEmail("safanasri002@gmail.com","Alerte ",alerte.getCause());
         String reponse=this.alerteserv.savealerte(Long.parseLong(alerte.getNumerocpt()), alerte.getCause(), Integer.parseInt(alerte.getCodesecret()),id_u);
         return ResponseEntity.ok(reponse) ;

     }
}
