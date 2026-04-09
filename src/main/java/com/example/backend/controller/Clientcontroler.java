package com.example.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Client;
import com.example.backend.respitory.Clientrepository;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class Clientcontroler {
      
    private final Clientrepository clientresp;


    Clientcontroler(Clientrepository clientresp){this.clientresp=clientresp;}
     

    @GetMapping("/clients")
    public Iterable<Client> getClient() {
        System.out.println("ok");
        return this.clientresp.findAll();
    }
    
}
