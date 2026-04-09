package com.example.backend.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Bd.Transactions;

@Repository

public interface Transactionsrepository extends ListCrudRepository<Transactions, Integer> {

}
