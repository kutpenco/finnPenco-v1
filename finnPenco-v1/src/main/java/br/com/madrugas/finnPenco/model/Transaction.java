package br.com.madrugas.finnPenco.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean transaction;
	private String description;
	private LocalDate date;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Category category;
	private String type;
	private BigDecimal value;
	private String obs;
	
	
	public Transaction(Boolean transaction, String description, Category category, String type, BigDecimal value,
			String obs) {
		this.transaction = transaction;
		this.description = description;
		this.date = LocalDate.now();
		this.category = category;
		this.type = type;
		this.value = value;
		this.obs = obs;
	}
	
	public Transaction() {}
	
	public Boolean getTransaction() {
		return transaction;
	}

	public Integer getId() {
		return id;
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
