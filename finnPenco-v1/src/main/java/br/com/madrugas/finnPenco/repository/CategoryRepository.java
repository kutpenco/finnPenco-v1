package br.com.madrugas.finnPenco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.madrugas.finnPenco.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Optional<Category> findOne(String name);

}
