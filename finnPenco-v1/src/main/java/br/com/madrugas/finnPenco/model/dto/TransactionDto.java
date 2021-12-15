package br.com.madrugas.finnPenco.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.madrugas.finnPenco.model.Category;
import br.com.madrugas.finnPenco.model.Transaction;

public class TransactionDto {
	
	private Boolean transaction;
	private String description;
	private LocalDate date;
	private int categoryId;
	private String type;
	private BigDecimal value;
	private String obs;

	public TransactionDto(Boolean transaction, String description, LocalDate date, int categoryId, String type,
			BigDecimal value, String obs) {
		this.transaction = transaction;
		this.description = description;
		this.date = date;
		this.categoryId = categoryId;
		this.type = type;
		this.value = value;
		this.obs = obs;
	}

	public Boolean getTransaction() {
		return transaction;
	}

	public void setTransaction(Boolean transaction) {
		this.transaction = transaction;
	}

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

	public Transaction toTransaction(Category category) {
		return toTransaction(category);
		//return new Transaction(value, typeMoviment, detail, category);
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
