package com.example.backend.entity.Bd;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="transactions")

public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idtr;
    private Date dateheure;
    private BigDecimal montant;
    private int duree;
    private String localisation;
    private String statut;
    private String typefr = null;

    @ManyToOne
    @JoinColumn (name="idadmin")
    private Administrateur admin=null;
    public void setAdministrateur(Administrateur admin) {this.admin = admin;}
    public Administrateur getAdministrateur() {return admin;}

    @ManyToOne
    @JoinColumn (name="idcp")
    private Compte compte;
    public void setCompte(Compte cp) {this.compte = cp;}
    public Compte getCompte() {return compte;}


    public Transactions() {}

     Transactions(Date date_heure, BigDecimal montant, int duree, String localisation, String statut,String type_fr) {
        this.dateheure = date_heure;
        this.montant = montant;
        this.duree = duree;
        this.localisation = localisation;
        this.statut = statut;
        this.typefr = type_fr;
    }
     public int getId_tr() {
         return idtr;
     }
     public void setId_tr(int id_tr) {
         this.idtr = id_tr;
     }
     public Date getDate_heure() {
         return dateheure;
     }
     public void setDate_heure(Date date_heure) {
         this.dateheure = date_heure;
     }
     public BigDecimal getMontant() {
         return montant;
     }
     public void setMontant(BigDecimal montant) {
         this.montant = montant;
     }
     public int getDuree() {
         return duree;
     }
     public void setDuree(int duree) {
         this.duree = duree;
     }
     public String getLocalisation() {
         return localisation;
     }
     public void setLocalisation(String localisation) {
         this.localisation = localisation;
     }
     public String getStatut() {
         return statut;
     }
     public void setStatut(String statut) {
         this.statut = statut;
     }
     public String getType_fr() {
         return typefr;
     }
     public void setType_fr(String type_fr) {
         this.typefr = type_fr;
     }
    
}
