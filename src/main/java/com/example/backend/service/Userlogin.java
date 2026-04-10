package com.example.backend.service;


import org.springframework.stereotype.Service;

import com.example.backend.entity.Bd.Client;
import com.example.backend.repository.Clientrepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class Userlogin {

    private Clientrepository clientrepo ;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Userlogin(Clientrepository client){
        this.clientrepo=client;
    }

    public Integer authenticateClient(String nom , String mdp){
        
        Client client=this.clientrepo.findByNomaccess(nom);
        
        if(client==null){
            System.out.println("client non trouve");
            return 0;
        }else{
           if (passwordEncoder.matches(mdp,client.getPassword())) {
              return client.getId();
           } else {
                 System.out.println("error: mot de passe invalid ");
                 return 0;
           }
        }
    }


}
