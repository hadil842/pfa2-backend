package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Bd.Administrateur;
import com.example.backend.entity.Bd.Compte;
import com.example.backend.repository.Adminrepository;
import com.example.backend.repository.Compterepository;

@Service

public class Bolquercompteservice {

    public Adminrepository admirespository;
    public Compterepository compterepository;

    public Bolquercompteservice(Adminrepository admirespository, Compterepository compterepository) {
        this.admirespository = admirespository;
        this.compterepository = compterepository;
    }

    public String bloquercompte(long numcp, int id_adm, int codesecret,String cause){
        Administrateur admin =this.admirespository.findById(id_adm); 
        if(admin.getSecretCode()==codesecret){
            Compte cp=this.compterepository.findByNumcompte(numcp);

            if (cp==null){
                return "Compte non trouvé";}

            cp.setEtat("bloqué");
            cp.setCauseblocage(cause);

            this.compterepository.save(cp);

            return "Compte bloqué";
        }
        else {
            return "Code secret invalide";
        }

    } 

    public String debloquercompte(long numcp, int id_adm, int codesecret,String cause){

        Administrateur admin =this.admirespository.findById(id_adm); 

        if(admin.getSecretCode()==codesecret){

            Compte cp=this.compterepository.findByNumcompte(numcp);
            if (cp==null){return "Compte non trouvé";}

            cp.setEtat("actif");
            cp.setCauseblocage(cause);
            
            this.compterepository.save(cp);
            return "Compte debloqué";
        }
        else {
            return "Code secret invalide";
        }

    } 




}
