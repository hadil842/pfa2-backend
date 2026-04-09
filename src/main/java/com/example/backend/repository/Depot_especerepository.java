package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Depot_espece;

@Repository

public interface Depot_especerepository extends ListCrudRepository<Depot_espece, Integer> {

}
