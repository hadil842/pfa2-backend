package com.example.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Authreponse;
import com.example.backend.entity.Authrequest;

import com.example.backend.service.JWTservice;
import com.example.backend.service.Userlogin;
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

    public Logincontroler(Userlogin userservice, JWTservice jwtservice) {
        this.userservice = userservice;
        this.jwtservice = jwtservice;

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

            Map<String, Object> claims = new HashMap<>();
            claims.put("id_u", id_u);

            String jwt = this.jwtservice.createToken(claims, request.getNom());

            return ResponseEntity.ok(new Authreponse(jwt, etat));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @CrossOrigin
    @PostMapping("/loginadmin")
    public ResponseEntity<?> loginAdmin(@RequestBody Authrequest request) {

        Integer id_u = this.userservice.authenticateAdmin(request.getNom(), request.getMdp());

        if (id_u != 0) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", id_u);
            String jwt = this.jwtservice.createToken(claims, request.getNom());
            return ResponseEntity.ok(new Authreponse(jwt));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}
