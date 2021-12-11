package br.com.madrugas.finnPenco.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.madrugas.finnPenco.model.Category;

public class TransactionInputDto {

	private Boolean transaction;
	private String description;
	private LocalDate date;
	private Category category;
	private String type;
	private BigDecimal value;
	private String obs;
	
	
	public TransactionInputDto(Boolean transaction, String description, LocalDate date, Category category, String type, BigDecimal value,
			String obs) {
		this.transaction = transaction;
		this.description = description;
		this.date = LocalDate.now();
		this.category = category;
		this.type = type;
		this.value = value;
		this.obs = obs;
	}
	
	public Boolean getTransaction() {
		return transaction;
	}

	public String getDescription() {
		return description;
	}
	public LocalDate getDate() {
		return date;
	}
	public Category getCategory() {
		return category;
	}
	public String getType() {
		return type;
	}
	public BigDecimal getValue() {
		return value;
	}
	public String getObs() {
		return obs;
	}
}
