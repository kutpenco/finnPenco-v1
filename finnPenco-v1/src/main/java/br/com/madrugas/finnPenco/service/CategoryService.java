package br.com.madrugas.finnPenco.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.madrugas.finnPenco.model.Category;
import br.com.madrugas.finnPenco.model.dto.CategoryDto;
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
	
	//public Category findOne(String name) {
	//	return categoryRepository.findOne(name)
	//			.orElseThrow(() -> new EntityNotFoundException("Categoria  #{name} não encontrado"));
	//}
	
	public Category insertCategory(CategoryDto categoryDto) {
		return categoryRepository.save(categoryDto.toCategory());
	}
	
	public Category updateCategory(int id, CategoryDto categoryDto) {
		Category category = findById(id);
		category.setMaxSpending(categoryDto.getMaxSpending());
		category.setName(categoryDto.getName());
	
		return categoryRepository.save(category);
	}

	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}
	//Category save(Category categoria);

	//List<Category> searchAll();

	//Category searchById(Integer id);

	//void remove(Integer id);
	
	
}
