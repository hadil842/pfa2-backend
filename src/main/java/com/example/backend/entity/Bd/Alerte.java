package com.example.backend.entity.Bd;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="alerte")
public class Alerte {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idal;
    private Date date ;

    @ManyToOne
    @JoinColumn(name="idclient")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name="idadmin")
    private Administrateur administrateur;
     
    public Alerte() {}
    public Alerte(Date date, Client client, Administrateur administrateur) {
        this.date = date;
        this.client = client;
        this.administrateur = administrateur;
    }
    public int getId_al() {
        return idal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }


}
