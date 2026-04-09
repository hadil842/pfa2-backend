package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Retrait_espece;

@Repository

public interface Retrait_especerepository extends CrudRepository<Retrait_espece, Integer> {

}
