package br.com.madrugas.finnPenco.model;

import java.util.Date;

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
	private Date date;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
	private Category category;
	private String type;
	private String value;
	private String obs;
	
	
}
