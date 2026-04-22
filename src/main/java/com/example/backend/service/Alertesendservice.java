package com.example.backend.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Administrateur;
import com.example.backend.entity.Alerte;
import com.example.backend.entity.Client;
import com.example.backend.entity.Compte;
import com.example.backend.repository.Adminrepository;
import com.example.backend.repository.Alerterepository;
import com.example.backend.repository.Compterepository;

@Service
public class Alertesendservice {

 public Alerterepository alerterepo;
 public Adminrepository adminrepo;
 public Compterepository compterepo;

 public Alertesendservice(Alerterepository alerterepo, Adminrepository adminrepo, Compterepository compterepo) {
        this.alerterepo = alerterepo;
        this.adminrepo = adminrepo;
        this.compterepo = compterepo;
    }

 public String savealerte(long numerocpt, String cause, int codesecret, int idadmin) {

    Administrateur admin=this.adminrepo.findById(idadmin);
   if (admin.getSecretCode()==codesecret){
      Compte cpt=this.compterepo.findByNumcompte(numerocpt);
      if(cpt==null){
         return ("numero compte utilisateur unvalide");
      }
      Client cl=cpt.getClient();
      Alerte alerte =new Alerte(LocalDateTime.now(),cl,admin,cause);
      this.alerterepo.save(alerte);
      return("email est envoyé");
   }
   else{
      return("code secret invalide");
   }

 }
}
