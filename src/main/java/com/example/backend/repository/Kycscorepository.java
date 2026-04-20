package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Kycscore;


@Repository
public interface Kycscorepository extends ListCrudRepository<Kycscore, Integer> {

}
