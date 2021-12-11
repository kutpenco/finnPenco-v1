package br.com.madrugas.finnPenco.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.madrugas.finnPenco.model.Transaction;
import br.com.madrugas.finnPenco.model.dto.TransactionInputDto;
import br.com.madrugas.finnPenco.repository.CategoryRepository;
import br.com.madrugas.finnPenco.repository.TransactionRepository;

@Service
public class TransactionService {

	private TransactionRepository transactionRepository;
	
	public TransactionService(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository = transactionRepository;
	}


	@Transactional
	public Transaction saveTransaction(Transaction payload) {
		return TransactionRepository.save(payload.toPayload());
	}
	
	//private final TransactionRepository ;
	
	//Transaction save (Transaction transaction);
	
	//List<Transaction> searchAll();
	
	//Transaction searchById(Integer id);
	
	//void remove(Integer id);
	
		
}
