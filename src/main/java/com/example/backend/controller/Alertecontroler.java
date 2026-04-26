package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.Alerterequest;
import com.example.backend.service.Alertesendservice;
import com.example.backend.service.EmailService;


@CrossOrigin(origins = { "http://localhost:4200", "null", "http://localhost:9090" })
@RestController

public class Alertecontroler {
    
    private Alertesendservice alerteserv;
    private EmailService emailServ;

    public Alertecontroler( Alertesendservice alerteserv, EmailService emailServ) {
        this.alerteserv = alerteserv;
        this.emailServ = emailServ;
    }

    @CrossOrigin
    @PostMapping("/alerte")
    public ResponseEntity<?> envoyeralerte(@RequestBody Alerterequest alerte) {

       
        
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        int id_u = Integer.parseInt(userId);

        this.emailServ.sendEmail("safanasri002@gmail.com", "Alerte ", alerte.getCause());
        String reponse = this.alerteserv.savealerte(Long.parseLong(alerte.getNumerocpt()), alerte.getCause(),
                Integer.parseInt(alerte.getCodesecret()), id_u);
        return ResponseEntity.ok(reponse);

    }
}
