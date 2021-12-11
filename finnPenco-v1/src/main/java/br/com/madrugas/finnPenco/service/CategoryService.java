package br.com.madrugas.finnPenco.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.madrugas.finnPenco.model.Category;
import br.com.madrugas.finnPenco.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category findById(Integer id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Categoria  #{id} não encontrado"));
	}
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findOne(String name) {
		return categoryRepository.findOne(name)
				.orElseThrow(() -> new EntityNotFoundException("Categoria  #{name} não encontrado"));
	}
	//Category save(Category categoria);

	//List<Category> searchAll();

	//Category searchById(Integer id);

	//void remove(Integer id);
	
	
}
