package com.example.backend.service;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Acceilreponse;
import com.example.backend.entity.nbstatut;
import com.example.backend.entity.Bd.Transactions;
import com.example.backend.repository.Depot_especerepository;
import com.example.backend.repository.Paiementrepository;
import com.example.backend.repository.Retrait_especerepository;
import com.example.backend.repository.Transactionsrepository;
import com.example.backend.repository.Virementrepository;

@Service
public class Admintransactionservice {
    public Transactionsrepository transactionrepository;

    public Paiementrepository paiementrepository;
    public Virementrepository virementrepository;
    public Retrait_especerepository retrait_especerepository;
    public Depot_especerepository depot_especerepository;

    public Admintransactionservice(Transactionsrepository transactionrepository, Paiementrepository paiementrepository,
            Virementrepository virementrepository, Retrait_especerepository retrait_especerepository,
            Depot_especerepository depot_especerepository) {
        this.transactionrepository = transactionrepository;
        this.paiementrepository = paiementrepository;
        this.virementrepository = virementrepository;
        this.retrait_especerepository = retrait_especerepository;
        this.depot_especerepository = depot_especerepository;
    }

    public String getType(int id_tr) {

        if (this.paiementrepository.existsById(id_tr))
            return "Paiement " + this.paiementrepository.findById(id_tr).getDestination();
        else if (this.virementrepository.existsById(id_tr))
            return "Virement Sortant";
        else if (this.depot_especerepository.existsById(id_tr))
            return "Depot Espece";
        else if (this.retrait_especerepository.existsById(id_tr))
            return "Retrait Espece";
        else
            return "Virement Entrant";
    }

    public List<Acceilreponse> getAllTransactions() {

        List<Transactions> transactions = transactionrepository.findAllByOrderByDateheureAsc();

        List<Acceilreponse> reponses = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (Transactions t : transactions) {
            int id = t.getId_tr();
            int ncp = (int) t.getCompte().getNumcompte();

            BigDecimal solde = t.getMontant();

            String date = "";
            if (t.getDateheure() != null)
                date = sdf.format(t.getDateheure());

            String type_tr = getType(id);

            String statut = t.getStatut();

            Acceilreponse r = new Acceilreponse(String.valueOf(ncp), type_tr, String.valueOf(solde), date, statut);
            reponses.add(r);

        }
        return reponses;
    }

    public nbstatut calculer() {
        BigDecimal solde = transactionrepository.sumAllMontants();
        int nbsucess = transactionrepository.countByStatut("validee");
        int nbencours = transactionrepository.countByStatut("en_cours");
        int nbrefu = transactionrepository.countByStatut("refusee");

        return new nbstatut(String.valueOf(solde), String.valueOf(nbsucess), String.valueOf(nbencours),
                String.valueOf(nbrefu));

    }

}
