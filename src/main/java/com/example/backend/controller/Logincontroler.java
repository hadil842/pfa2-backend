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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;







@RestController
public class Logincontroler {
      
    private Userlogin userservice;
    private JWTservice jwtservice;



    public Logincontroler(Userlogin user,JWTservice jwt){
        this.jwtservice=jwt;
        this.userservice=user;
    }

    @PostMapping("/loginclient")
    public ResponseEntity<?> loginclient(@RequestBody Authrequest request) {
        Integer id=this.userservice.authenticateClient(request.getNom(),request.getMdp());
        
        if(id!=0){
                 
            Map<String,Object>claims=new HashMap<>();
            claims.put("id",id);
       
            String jwt=this.jwtservice.createToken(claims,request.getNom());

            return ResponseEntity.ok(new Authreponse(jwt));
        }else{
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    

    @PostMapping("/loginadmin")

    public ResponseEntity<?> loginAdmin (@RequestBody Authrequest request){

        Integer id= this.userservice.authenticateAdmin(request.getNom(),request.getMdp());
    
        if (id!=0){
            Map<String,Object>claims=new HashMap<>();
            claims.put("id",id);
            String jwt=this.jwtservice.createToken(claims,request.getNom());
            return ResponseEntity.ok(new Authreponse(jwt));}
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    
}
