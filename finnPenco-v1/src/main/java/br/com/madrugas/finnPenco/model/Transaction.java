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
	private String description;
	private LocalDate date;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Category category;
	private String type;
	private BigDecimal value;
	private String obs;
	
	
	public Transaction(Integer id, String description, Category category, String type, BigDecimal value,
			String obs) {
		this.id = id;
		this.description = description;
		this.date = LocalDate.now();
		this.category = category;
		this.type = type;
		this.value = value;
		this.obs = obs;
	}
	
	public Transaction() {}
	
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
