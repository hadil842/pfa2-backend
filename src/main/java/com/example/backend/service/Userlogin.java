package com.example.backend.service;


import org.springframework.stereotype.Service;

import com.example.backend.entity.Bd.Administrateur;
import com.example.backend.entity.Bd.Client;
import com.example.backend.repository.Adminrepository;
import com.example.backend.repository.Clientrepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class Userlogin {

    private Clientrepository clientrepo ;
    private Adminrepository adminrepo ;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Userlogin(Clientrepository client, Adminrepository admin){
        this.clientrepo=client;
        this.adminrepo=admin;
    }

    public Integer authenticateClient(String nom , String mdp){
        
        Client client=this.clientrepo.findByNomaccess(nom);
        
        if(client==null){
            System.out.println("error: nom d'utilisateur invalid ");
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


    public Integer authenticateAdmin (String nom , String mdp){

        Administrateur admin=this.adminrepo.findByNomaccess(nom);

        if (admin == null) {
            System.out.println("error: nom d'administrateur invalid ");
            return 0;}

        else {
            if(passwordEncoder.matches(mdp,admin.getPassword()))
                {return admin.getId(); }
            
            else{
                System.out.println("error: mot de passe invalid ");
                    return 0;
            }

        }

}

}
