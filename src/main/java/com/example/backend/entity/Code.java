package com.example.backend.entity;

import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="code")
public class Code {
      
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idc;

    public Code() {
    }

    public int getIdc() {
        return idc;
    }

    private int code;
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private LocalDateTime date;
    
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @OneToOne
    @JoinColumn(name="idu")
    private Utilisateur utilisateur;

    public Code(int code, LocalDateTime date, Utilisateur utilisateur) {
        this.code = code;
        this.date = date;
        this.utilisateur = utilisateur;
    }
}
