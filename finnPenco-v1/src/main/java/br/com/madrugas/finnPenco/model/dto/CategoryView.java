package br.com.madrugas.finnPenco.model.dto;

public class CategoryView {

	private int id;
	private String name;
	private double maxSpending;

	public CategoryView(int id, String name, double maxSpending) {
		this.id = id;
		this.name = name;
		this.maxSpending = maxSpending;
	}

	public CategoryView() {}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getMaxSpending() {
		return maxSpending;
	}
}
