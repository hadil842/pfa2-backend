package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Retrait_espece;

@Repository

public interface Retrait_especerepository extends ListCrudRepository<Retrait_espece, Integer> {

}
