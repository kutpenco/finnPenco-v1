package br.com.madrugas.finnPenco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.madrugas.finnPenco.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
