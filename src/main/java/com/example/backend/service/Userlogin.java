package com.example.backend.service;


import org.springframework.stereotype.Service;

import com.example.backend.entity.Administrateur;
import com.example.backend.entity.Client;
import com.example.backend.entity.Compte;
import com.example.backend.repository.Adminrepository;
import com.example.backend.repository.Clientrepository;
import com.example.backend.repository.Compterepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class Userlogin {

    private Clientrepository clientrepo ;
    private Adminrepository adminrepo ;
    private Compterepository compterepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Userlogin(Clientrepository client, Adminrepository admin,Compterepository compterepository){
        this.clientrepo=client;
        this.adminrepo=admin;
        this.compterepository=compterepository;
    }


    public Map<String,Object> authenticateClient(String nom , String mdp){
        
        Client client=this.clientrepo.findByNomaccess(nom);
        Compte compte =this.compterepository.findByClient(client);


        if(client==null){
            System.out.println("error: nom d'utilisateur invalid ");
            return null;
        }else{
           if (passwordEncoder.matches(mdp,client.getPassword())) {

              HashMap<String,Object>result=new HashMap<>();
              result.put("id_u",client.getId());
              result.put("etat",compte.getEtat());
              return result;
              
           } else {
                 System.out.println("error: mot de passe invalid ");
                 return null;
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
