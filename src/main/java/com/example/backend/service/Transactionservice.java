package com.example.backend.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.List;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Recordreponse;
import com.example.backend.entity.Transactionsreponse;
import com.example.backend.entity.Bd.Compte;

import com.example.backend.entity.Bd.Transactions;

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

    
   public List<Transactionsreponse>getList(Compte compte){
    
      List<Transactions>result=this.transactionrepository.findByCompte(compte);
      List<Transactionsreponse>reponse=new ArrayList<>(20);
    
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      Random random = new Random();
      for(Transactions tr :result){

        String date="";
        if(tr.getDate_heure()!=null)date = sdf.format(tr.getDate_heure());

        int id_tr=tr.getId_tr();

        String type=getType(id_tr);
        

        
        int randomInt = random.nextInt(1000);
        String reference="F"+String.valueOf(randomInt)+"-A";
        
        String montant ="";
        if(type.equals("Depot Espece"))montant+="+";
        else montant+="-";

        montant+= String.valueOf(tr.getMontant());

        String statut=tr.getStatut();

        reponse.add(new Transactionsreponse(date,type,reference,montant,statut));
      }
      return reponse;

   }
   public String getType(int id_tr){
        
        if(this.paiementrepository.existsById(id_tr)){
              return "Paiement "+this.paiementrepository.findById(id_tr).getDestination();
        }else if(this.virementrepository.existsById(id_tr))return "Virement";
        else if(this.depot_especerepository.existsById(id_tr))return "Depot Espece";
        else return "Retrait Espece";
   }
   public List<Recordreponse>getRecord(Compte compte){

     List<Recordreponse>resultat=new ArrayList();

     List<Transactions>table=this.transactionrepository.findByCompteOrderByDateheureAsc(compte);
     
     BigDecimal val_com=compte.getSolde_init();
     resultat.add(new Recordreponse(compte.getDate_creation(),val_com));
     
     for(int i=0;i<table.size();i++){

      int id_tr=table.get(i).getId_tr();

      if(this.paiementrepository.existsById(id_tr)||
       this.virementrepository.existsById(id_tr)||this.depot_especerepository.existsById(id_tr)){
         if(table.get(i).getStatut().equals("validee")) val_com=val_com.subtract(table.get(i).getMontant());
      }else {
         if(table.get(i).getStatut().equals("validee")) val_com=val_com.add(table.get(i).getMontant());
      }
      resultat.add(new Recordreponse(table.get(i).getDate_heure(),val_com));
      
     }
     
     return resultat;
     

   }
}
