package br.com.madrugas.finnPenco.model.dto;

import br.com.madrugas.finnPenco.model.Category;

public class CategoryDto {

	private String name;
	private double maxSpending;
	
	public CategoryDto(String name, double maxSpending) {
		this.name = name;
		this.maxSpending = maxSpending;
	}

	public String getName() {
		return name;
	}

	public double getMaxSpending() {
		return maxSpending;
	}

	public Category toCategory() {
		return new Category(name, maxSpending);
	}
}
