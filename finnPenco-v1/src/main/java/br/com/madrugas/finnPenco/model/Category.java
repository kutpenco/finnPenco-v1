package br.com.madrugas.finnPenco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Long maxSpending;
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Long getMaxSpending() {
		return maxSpending;
	}
	
	@OneToOne(mappedBy = "category")
    private Transaction transaction;
	
}
