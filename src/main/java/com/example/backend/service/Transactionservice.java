package com.example.backend.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Transactionsreponse;
import com.example.backend.entity.Bd.Compte;
import com.example.backend.entity.Bd.Transactions;
import com.example.backend.repository.Depot_especerepository;
import com.example.backend.repository.Paiementrepository;

import com.example.backend.repository.Transactionsrepository;
import com.example.backend.repository.Virementrepository;

@Service
public class Transactionservice {

    public Transactionsrepository transactionrepository;
    public Paiementrepository paiementrepository;
    public Virementrepository virementrepository;
    
    
    public Transactionservice(Transactionsrepository transactionrepository, Paiementrepository paiementrepository,
            Virementrepository virementrepository,
            Depot_especerepository depot_especerepository) {
        this.transactionrepository = transactionrepository;
        this.paiementrepository = paiementrepository;
        this.virementrepository = virementrepository;
        this.depot_especerepository = depot_especerepository;
    }


    public Depot_especerepository depot_especerepository;

    
   public List<Transactionsreponse>getList(Compte compte){
    
      List<Transactions>result=this.transactionrepository.findByCompte(compte);
      List<Transactionsreponse>reponse=new ArrayList<>(20);
    
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      Random random = new Random();
      for(Transactions tr :result){

       
        String date = sdf.format(tr.getDate_heure());

        int id_tr=tr.getId_tr();

        String type=getType(id_tr);
        

        
        int randomInt = random.nextInt(1000);
        String reference="F"+String.valueOf(randomInt)+"-A";
        
        String montant ="";
        if(type.equals("Depot Espece"))montant+="+";
        else montant+="-";

        montant+= String.valueOf(tr.getMontant());

        reponse.add(new Transactionsreponse(date,type,reference,montant));
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
}
