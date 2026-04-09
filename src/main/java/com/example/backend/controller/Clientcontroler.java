package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Bd.Virement;
import com.example.backend.repository.Virementrepository;




@RestController
public class Clientcontroler {
      
    private final Virementrepository clientresp;


    Clientcontroler(Virementrepository clientresp){this.clientresp=clientresp;}
     

    @GetMapping("/clients")
    public List<Virement> getClient() {
        System.out.println("ok");
        return this.clientresp.findAll();
    }
    
}
