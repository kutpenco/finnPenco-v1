package br.com.madrugas.finnPenco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.madrugas.finnPenco.model.Category;
import br.com.madrugas.finnPenco.model.dto.CategoryDto;
import br.com.madrugas.finnPenco.model.dto.CategoryView;
import br.com.madrugas.finnPenco.service.CategoryService;

@RestController
@RequestMapping("/category")
public class ConfigurationController {

	private final CategoryService categoryService;
	
	public ConfigurationController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public ResponseEntity<CategoryView> insertCategory(@RequestBody CategoryDto categoryDto,
			UriComponentsBuilder uriBuilder) {
		Category category = categoryService.insertCategory(categoryDto);
		CategoryView categoryView = new CategoryView(category.getId(), category.getName(), category.getMaxSpending());
		return ResponseEntity.created(uriBuilder.path("category/{id}").buildAndExpand(categoryView.getId()).toUri()).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryView> searchById(@PathVariable int id) {
		Category category = categoryService.findById(id);
		return ResponseEntity.ok(new CategoryView(category.getId(), category.getName(), category.getMaxSpending()));
	}
	
	@GetMapping
	public ResponseEntity<?> searchAll() {
		return ResponseEntity.ok(categoryService.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryView> updateCategory(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
		Category category = categoryService.updateCategory(id, categoryDto);
		return ResponseEntity.ok(new CategoryView(category.getId(), category.getName(), category.getMaxSpending()));
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}
}
