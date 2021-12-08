package br.com.madrugas.finnPenco.model;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Report {

	private String description;
	private LocalDate date;
	private Category category;
	private String type;
	private BigDecimal value;
	private String obs;
	
	public Report(String description, LocalDate date, Category category, String type, BigDecimal value, String obs) {
		this.description = description;
		this.date = date;
		this.category = category;
		this.type = type;
		this.value = value;
		this.obs = obs;
	}
	
	public Report() {}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
