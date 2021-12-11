package br.com.madrugas.finnPenco.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.madrugas.finnPenco.model.Category;
import br.com.madrugas.finnPenco.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{

	List<Report> findByCategory(Category category);
	List<Report> findByDate(LocalDate date);
}
