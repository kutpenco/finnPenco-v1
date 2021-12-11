package br.com.madrugas.finnPenco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.madrugas.finnPenco.model.Category;
import br.com.madrugas.finnPenco.service.CategoryService;

@RestController
@RequestMapping("/category")
public class ConfigurationController {

	private final CategoryService categoryService;
	
	public ConfigurationController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public ResponseEntity<Category> save(@RequestBody Category category) {
		Category category1 = new Category();
		return categoryService.save(category1);
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		categoryService.remove(id);
	}
	@GetMapping
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok(categoryService.searchAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Category category = categoryService.searchById(id);
		return ResponseEntity.ok(category);
	}
}
