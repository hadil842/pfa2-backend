package com.example.backend.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Client;
import com.example.backend.entity.Compte;
import com.example.backend.entity.Virement;
import com.example.backend.repository.Clientrepository;
import com.example.backend.repository.Compterepository;
import com.example.backend.repository.Virementrepository;

import jakarta.transaction.Transactional;

@Service
public class Virementservice {

    public EmailService email;
    public Clientrepository clientrepository;
    public Compterepository compterepository;
    public Verificationservice codeser;
    public Redisservice redisservice;
    public Virementrepository virmentrepo;

   

    public Virementservice(EmailService email, Clientrepository clientrepository, Compterepository compterepository,
            Verificationservice codeser, Redisservice redisservice, Virementrepository virmentrepo) {
        this.email = email;
        this.clientrepository = clientrepository;
        this.compterepository = compterepository;
        this.codeser = codeser;
        this.redisservice = redisservice;
        this.virmentrepo = virmentrepo;
    }

    public void preparerVirement(int idclient,long numdest,BigDecimal montant,int codesecret,String nomrecep) {
        Client client=this.clientrepository.findById(idclient);
        Compte comptesource = this.compterepository.findByClient(client);


        if (comptesource == null) {
            throw new RuntimeException("Compte source introuvable");
        }

        String data = comptesource.getNumcompte()+ "," + numdest+ "," + montant + ","
                + codesecret+","+nomrecep;

        redisservice.saveVirement(idclient, data);
        int code = codeser.genererCode(idclient);
        String emailDestinataire = "hadilkharroubi85@gmail.com";
        String sujet = "Validation de votre virment";
        String message = "Bonjour, votre code de confirmation pour le virement est : " + code;
        email.sendEmail(emailDestinataire, sujet, message);
    }

    @Transactional
    public String effectuerVirement(int id_u, int code) {
        String result = codeser.verifierCode(id_u, code);
        if (!"code correct".equals(result)) {
            return "code email incorrect " ;
        }
        String data = redisservice.getVirement(id_u);
        if (data == null) {
            return "cordonnes sont vides";
        }
        String[] parts = data.split(",");

        long numsource = Long.parseLong(parts[0]);
        long numdestination = Long.parseLong(parts[1]);
        BigDecimal montant = new BigDecimal(parts[2]);
        int codesecret=Integer.parseInt(parts[3]);
        String nomrecep=parts[4];

        Compte comptesource = this.compterepository.findByNumcompte(numsource);
        Compte comptedestination = this.compterepository.findByNumcompte(numdestination);

        if (comptedestination == null) {
            return "numero de compte destination invalide ";
        }
        
        if (comptesource.getSolde().compareTo(montant) < 0) {
            return "montant inferieur";
        }

        if(codesecret!=comptesource.getCode_secret_compte()){
            return "code secret invalide";
        }

        comptesource.setSolde(comptesource.getSolde().subtract(montant));
        comptedestination.setSolde(comptedestination.getSolde().add(montant));

        compterepository.save(comptesource);
        compterepository.save(comptedestination);

       
        Virement vir=new Virement(new Date(),montant,"en ligne","en ligne","validee",nomrecep,numdestination,comptesource);
       
        this.virmentrepo.save(vir);
        
        redisservice.deleteVirement(id_u);
        return "virement effectuee avec succes ";

    }

}