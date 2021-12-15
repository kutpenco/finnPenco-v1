package br.com.madrugas.finnPenco.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.madrugas.finnPenco.model.Category;
import br.com.madrugas.finnPenco.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	List<Transaction> findByDataInclusaoBetween(LocalDate firstDayOfMonth, LocalDate lastDayOfMonth);

	List<Transaction> findByDataInclusao(LocalDate currentDate);
	
	List<Transaction> findByDataInclusaoBetweenAndCategoria(LocalDate firstDayOfMonth, LocalDate lastDayOfMonth, Category category);
}
