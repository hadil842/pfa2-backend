package com.example.backend.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



import org.springframework.stereotype.Service;

import com.example.backend.DTO.Recordreponse;
import com.example.backend.DTO.Transactionsreponse;
import com.example.backend.entity.Compte;

import com.example.backend.entity.Transactions;
import com.example.backend.entity.Virement;
import com.example.backend.repository.Depot_especerepository;
import com.example.backend.repository.Paiementrepository;
import com.example.backend.repository.Retrait_especerepository;
import com.example.backend.repository.Transactionsrepository;
import com.example.backend.repository.Virementrepository;

@Service
public class Transactionservice {

   public Transactionsrepository transactionrepository;
   public Paiementrepository paiementrepository;
   public Virementrepository virementrepository;
   public Retrait_especerepository retrait_especerepository;

   public Transactionservice(Transactionsrepository transactionrepository, Paiementrepository paiementrepository,
         Virementrepository virementrepository, Retrait_especerepository retrait_especerepository,
         Depot_especerepository depot_especerepository) {
      this.transactionrepository = transactionrepository;
      this.paiementrepository = paiementrepository;
      this.virementrepository = virementrepository;
      this.retrait_especerepository = retrait_especerepository;
      this.depot_especerepository = depot_especerepository;
   }

   public Depot_especerepository depot_especerepository;

   public List<Transactionsreponse> getList(Compte compte) {

      List<Transactions> result = this.transactionrepository.findByCompte(compte);
      List<Transactionsreponse> reponse = new ArrayList<>(20);

      for (Transactions tr : result) {
         reponse.add(redigeTransactions(tr));
      }

      if (this.virementrepository.existsByNumcompterece(compte.getId_cp())) {

         List<Virement> virements = this.virementrepository.findByNumcompterece(compte.getId_cp());

         for (Virement v : virements) {
            reponse.add(redigeTransactions(v));
         }

      }
      return reponse;

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

   public Transactionsreponse redigeTransactions(Transactions tr) {

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
     

      String date = "";
      if (tr.getDateheure() != null)
         date = sdf.format(tr.getDateheure());

      int id_tr = tr.getId_tr();

      String type = getType(id_tr);

     

      String montant = "";
      if (type.equals("Depot Espece") || type.equals("Virement Entrant"))
         montant += "+";
      else
         montant += "-";

      montant += String.valueOf(tr.getMontant());

      String statut = tr.getStatut();
      String localisation=tr.getLocalisation();

      return new Transactionsreponse(date, type, montant, statut,localisation);
   }

   public List<Recordreponse> getRecord(Compte compte) {

      List<Recordreponse> resultat = new ArrayList<>();

      List<Transactions> table = this.transactionrepository.findByCompteOrderByDateheureAsc(compte);

      if (this.virementrepository.existsByNumcompterece(compte.getId_cp())) {

         List<Virement> virements = this.virementrepository.findByNumcompterece(compte.getId_cp());

         table.addAll(virements);

         table.sort(Comparator.comparing(Transactions::getDateheure));

      }

      BigDecimal val_com = compte.getSolde_init();
      resultat.add(new Recordreponse(compte.getDate_creation(), val_com));

      for (int i = 0; i < table.size(); i++) {

         int id_tr = table.get(i).getId_tr();
         Virement v = this.virementrepository.findById(id_tr);

         boolean check = this.paiementrepository.existsById(id_tr) ||
               (v != null && compte.getId_cp() != v.getNum_copmte_erce())
               || this.retrait_especerepository.existsById(id_tr);

         if (check) {
            if (table.get(i).getStatut().equals("validee"))
               val_com = val_com.subtract(table.get(i).getMontant());
         } else {
            if (table.get(i).getStatut().equals("validee"))
               val_com = val_com.add(table.get(i).getMontant());
         }
         resultat.add(new Recordreponse(table.get(i).getDateheure(), val_com));

      }

      return resultat;

   }

}
