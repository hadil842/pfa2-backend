package com.example.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.acceilreponse;
import com.example.backend.entity.nbstatut;
import com.example.backend.service.Admintransactionservice;

@CrossOrigin(origins = { "http://localhost:4200", "null", "http://localhost:9090" })
@RestController

public class Transactioncontroller {

    public Admintransactionservice tservice;

    public Transactioncontroller(Admintransactionservice tservice) {
        this.tservice = tservice;
    }
    @CrossOrigin
    @GetMapping("/afficherTansAdmin")
    public List<acceilreponse> getTransactions() {
        return tservice.getAllTransactions();
    }
    @CrossOrigin
    @GetMapping("/calculer")
    public ResponseEntity<nbstatut> count() {
        return ResponseEntity.ok(tservice.calculer());
    }

}
