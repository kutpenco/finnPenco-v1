package br.com.madrugas.finnPenco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.madrugas.finnPenco.model.Transaction;
import br.com.madrugas.finnPenco.model.dto.TransactionDto;
import br.com.madrugas.finnPenco.model.dto.TransactionView;
import br.com.madrugas.finnPenco.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	private TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping
	public ResponseEntity<TransactionView> insertTransaction(@RequestBody TransactionDto transactionDto,
			UriComponentsBuilder uriBuilder) {
		Transaction transaction = transactionService.insertTransaction(transactionDto);
		TransactionView transactionView = new TransactionView(transaction.getId(), transaction.getName(), transaction.getMaxSpending());
		return ResponseEntity.created(uriBuilder.path("transaction/{id}").buildAndExpand(transactionView.getId()).toUri()).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<TransactionView> searchById(@PathVariable int id) {
		Transaction transaction = transactionService.findById(id);
		return ResponseEntity.ok(new TransactionView(transaction.getId(), transaction.getName(), transaction.getMaxSpending()));
	}
	
	@GetMapping
	public ResponseEntity<?> searchAll() {
		return ResponseEntity.ok(transactionService.findAll());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TransactionView> updateTransaction(@PathVariable int id, @RequestBody TransactionDto transactionDto) {
		Transaction transaction = transactionService.updateTransaction(id, transactionDto);
		return ResponseEntity.ok(new TransactionView(transaction.getId(), transaction.getName(), transaction.getMaxSpending()));
	}

	@DeleteMapping("/{id}")
	public void deleteTransaction(@PathVariable int id) {
		transactionService.deleteTransaction(id);
	}
}
