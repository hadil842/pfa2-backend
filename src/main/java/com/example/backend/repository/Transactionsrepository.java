package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Transactions;

@Repository

public interface Transactionsrepository extends CrudRepository<Transactions, Integer> {

}
