package com.example.backend.entity;

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
    private String localisation;
    private String marchandcateg ;
    private String statut;
    private Integer typefr;

    

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

     Transactions(Date dateheure, BigDecimal montant, String localisation,String marchandcateg, String statut) {
        this.dateheure = dateheure;
        this.montant = montant;
        this.localisation = localisation;
        this.marchandcateg=marchandcateg;
        this.statut = statut;
    }
     public int getId_tr() {
         return idtr;
     }
     public void setId_tr(int id_tr) {
         this.idtr = id_tr;
     }
     public Date getDateheure() {
         return dateheure;
     }
     public void setDateheure(Date date_heure) {
         this.dateheure = date_heure;
     }
     public BigDecimal getMontant() {
         return montant;
     }
     public void setMontant(BigDecimal montant) {
         this.montant = montant;
     }
     public String getMarchandcateg() {
        return marchandcateg;
    }
    public void setMarchandcateg(String marchandcateg) {
        this.marchandcateg = marchandcateg;
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
     public Integer getTypefr() {
         return typefr;
     }
     public void setTypefr(Integer type_fr) {
         this.typefr = type_fr;
     }
    
}
