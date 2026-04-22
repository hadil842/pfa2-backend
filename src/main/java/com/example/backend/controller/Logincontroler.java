package com.example.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.Authreponse;
import com.example.backend.DTO.Authrequest;
import com.example.backend.DTO.Verificationreponse;
import com.example.backend.DTO.Verificationrequest;
import com.example.backend.service.EmailService;
import com.example.backend.service.JWTservice;
import com.example.backend.service.Userlogin;
import com.example.backend.service.Verificationservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "http://localhost:4200", "null", "http://localhost:9090" })
@RestController
public class Logincontroler {

    private Userlogin userservice;
    private JWTservice jwtservice;
    private Verificationservice verificationserv;
    private EmailService emailService;

    public Logincontroler(Userlogin userservice, JWTservice jwtservice, Verificationservice verificationserv,EmailService emailService) {
        this.userservice = userservice;
        this.jwtservice = jwtservice;
        this.verificationserv = verificationserv;
        this.emailService=emailService;
    }

    @CrossOrigin
    @PostMapping("/loginclient")
    public ResponseEntity<?> loginclient(@RequestBody Authrequest request) {

        Map<String, Object> dict = this.userservice.authenticateClient(request.getNom(), request.getMdp());

        if (dict == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom utilisateur invalide");

        int id_u = (int) dict.get("id_u");
        String etat = String.valueOf(dict.get("etat"));

        if (id_u != 0) {

            if(etat.equals("bloqué "))return ResponseEntity.ok(new Authreponse(0, etat));
            else {
                int code =this.verificationserv.genererCode(id_u);
      
                this.emailService.sendEmail("safanasri002@gmail.com","Verification ",String.valueOf(code));
                /*this.emailService.sendEmail("","Verification ",String.valueOf(code));*/

                return ResponseEntity.ok(new Authreponse(id_u ,etat));
            }
           
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    @CrossOrigin
    @PostMapping("/verification-client")
    public ResponseEntity<?> verificationclient(@RequestBody Verificationrequest request) {
        String reponse=this.verificationserv.verifierCode(request.getId_u(),request.getCode());

        if(reponse.equals("code expire")){
           return ResponseEntity.ok(new Verificationreponse("code expire"));
        }else if(reponse.equals("code incorrect"))return ResponseEntity.ok(new Verificationreponse("code incorrect"));
        else{
            Map<String, Object> claims = new HashMap<>();
            claims.put("role","client");

            String jwt = this.jwtservice.createToken(claims,String.valueOf(request.getId_u()));
            return ResponseEntity.ok(new Verificationreponse("code correct",jwt));
        }}
       

     

    





    @CrossOrigin
    @PostMapping("/loginadmin")
    public ResponseEntity<?> loginAdmin(@RequestBody Authrequest request) {

       int id_u = this.userservice.authenticateAdmin(request.getNom(), request.getMdp());

        if (id_u == 0)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom administrateur invalide");

        if (id_u != 0) {
            int code =this.verificationserv.genererCode(id_u);
      
            this.emailService.sendEmail("safanasri002@gmail.com","Verification ",String.valueOf(code));
            /*this.emailService.sendEmail("","Verification ",String.valueOf(code));*/

            return ResponseEntity.ok(new Authreponse(id_u));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @CrossOrigin
    @PostMapping("/verification-admin")
    public ResponseEntity<?> verificationadmin(@RequestBody Verificationrequest request) {
        String reponse=this.verificationserv.verifierCode(request.getId_u(),request.getCode());

        if(reponse.equals("code expire")){
           return ResponseEntity.ok(new Verificationreponse("code expire"));
        }else if(reponse.equals("code incorrect"))return ResponseEntity.ok(new Verificationreponse("code incorrect"));
        else{
            Map<String, Object> claims = new HashMap<>();
            claims.put("role","admin");

            String jwt = this.jwtservice.createToken(claims,String.valueOf(request.getId_u()));
            return ResponseEntity.ok(new Verificationreponse("code correct",jwt));
        }}

}
