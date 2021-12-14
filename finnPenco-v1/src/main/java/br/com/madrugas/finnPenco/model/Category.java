package br.com.madrugas.finnPenco.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double maxSpending;
	
	@OneToMany(mappedBy = "transaction")
	@JsonIgnore
	private List<Transaction> transaction;
	
	public Category(String name, double maxSpending) {
		this.name = name;
		this.maxSpending = maxSpending;
	}
	
	public Category () {}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getMaxSpending() {
		return maxSpending;
	}
	public List<Transaction> getTransaction(){
		return transaction;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMaxSpending(double maxSpending) {
		this.maxSpending = maxSpending;
	}
}
