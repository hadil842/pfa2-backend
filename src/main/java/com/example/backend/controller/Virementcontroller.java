package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.DTO.Virementrequest;
import com.example.backend.entity.Compte;
import com.example.backend.repository.Compterepository;

import com.example.backend.service.Virementservice;

@CrossOrigin(origins = { "http://localhost:4200", "null", "http://localhost:9090" })
@RestController
public class Virementcontroller {
    private Virementservice virser;
    private Compterepository compterepo;

    public Virementcontroller(Virementservice virser, Compterepository compterepo) {
        this.virser = virser;
        this.compterepo = compterepo;
    }

    @CrossOrigin
    @PostMapping("/envoie")
    public ResponseEntity<?> envoyer(@RequestBody Virementrequest vir) {
        virser.preparerVirement(vir);
        return ResponseEntity.ok().body("Code envoyé par email");
    }

    @PostMapping("/confirmer")
    public ResponseEntity<?> confirmer(@RequestBody Virementrequest vir) {
        if (vir == null || vir.getCodesecret() == 0) {
            return ResponseEntity.badRequest().body("Requête invalide");
        }
        Compte source = compterepo.findByNumcompte(vir.getSource());
        int id_u = source.getClient().getId();
        int code = vir.getCodesecret();
        boolean result = virser.effectuerVirement(id_u, code);
        if (result) {
            return ResponseEntity.ok().body("Virement réussi");
        } else {
            return ResponseEntity.status(400).body("Code incorrect ou erreur de coordonnées");
        }
    }

}
