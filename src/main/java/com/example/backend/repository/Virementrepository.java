package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Virement;

@Repository

public interface Virementrepository extends CrudRepository<Virement, Integer> {

}
