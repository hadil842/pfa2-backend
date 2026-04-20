package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Administrateur;


@Repository
public interface Adminrepository extends ListCrudRepository<Administrateur, Integer> {

    public Administrateur findByNomaccess(String nom);
    public Administrateur findById(int id_adm);
}