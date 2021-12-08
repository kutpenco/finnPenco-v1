package br.com.madrugas.finnPenco.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionInputDto {

	private String description;
	private LocalDate date;
	private Category category;
	private String type;
	private BigDecimal value;
	private String obs;
	
}
