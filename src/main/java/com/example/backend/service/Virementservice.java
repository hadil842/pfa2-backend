package com.example.backend.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

import com.example.backend.DTO.Virementrequest;
import com.example.backend.entity.Compte;
import com.example.backend.repository.Clientrepository;
import com.example.backend.repository.Compterepository;

import jakarta.transaction.Transactional;

@Service
public class Virementservice {

    public EmailService email;
    public Clientrepository clientrepository;
    public Compterepository compterepository;
    public Verificationservice codeser;
    public Redisservice redisser;

    public Virementservice(EmailService email, Clientrepository clientrepository, Compterepository compterepository,
            Verificationservice codeser, Redisservice redisser) {
        this.email = email;
        this.clientrepository = clientrepository;
        this.compterepository = compterepository;
        this.codeser = codeser;
        this.redisser = redisser;
    }

    public void preparerVirement(Virementrequest request) {
        Compte source = this.compterepository.findByNumcompte(request.getSource());
        if (source == null) {
            throw new RuntimeException("Compte source introuvable");
        }

        String data = request.getSource() + "," + request.getDestination() + "," + request.getMontant() + ","
                + request.getCodesecret();
        int idClient = source.getClient().getId();

        redisser.saveVirement(idClient, data);
        int code = codeser.genererCode(idClient);
        String emailDestinataire = source.getClient().getEmail();
        String sujet = "Validation de votre virment";
        String message = "Bonjour, votre code de confirmation pour le virement est : " + code;
        email.sendEmail(emailDestinataire, sujet, message);
    }

    @Transactional
    public boolean effectuerVirement(int id_u, int code) {
        String result = codeser.verifierCode(id_u, code);
        if (!"code correct".equals(result)) {
            return false;
        }
        String data = redisser.getVirement(id_u);
        if (data == null) {
            return false;
        }
        String[] parts = data.split(",");
        if (parts.length < 3) {
            return false;
        }
        long source = Long.parseLong(parts[0]);
        long destination = Long.parseLong(parts[1]);
        BigDecimal montant = new BigDecimal(parts[2]);
        Compte csource = this.compterepository.findByNumcompte(source);
        Compte cdestination = this.compterepository.findByNumcompte(destination);

        if (csource == null || cdestination == null) {
            return false;
        }
        if (csource.getSolde().compareTo(montant) < 0) {
            return false;
        }

        csource.setSolde(csource.getSolde().subtract(montant));
        cdestination.setSolde(cdestination.getSolde().add(montant));

        compterepository.save(csource);
        compterepository.save(cdestination);

        redisser.deleteVirement(id_u);
        return true;

    }

}