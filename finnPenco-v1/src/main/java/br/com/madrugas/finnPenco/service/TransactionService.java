package br.com.madrugas.finnPenco.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.madrugas.finnPenco.model.Category;
import br.com.madrugas.finnPenco.model.Transaction;
import br.com.madrugas.finnPenco.model.dto.CategoryDto;
import br.com.madrugas.finnPenco.model.dto.TransactionDto;
import br.com.madrugas.finnPenco.model.dto.TransactionInputDto;
import br.com.madrugas.finnPenco.repository.CategoryRepository;
import br.com.madrugas.finnPenco.repository.TransactionRepository;

@Service
public class TransactionService {

	private TransactionRepository transactionRepository;
	private CategoryService categoryService;
		
	public TransactionService(TransactionRepository transactionRepository, CategoryService categoryService) {
		this.transactionRepository = transactionRepository;
		this.categoryService = categoryService;
	}

	public Transaction findById(Integer id) {
		return transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transação  #{id} não encontrado"));
	}
	
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}
	
	//public Transaction insertTransaction(CategoryDto categoryDto) {
	//	return transactionRepository.save(categoryDto.toCategory());
	//}
	
	public Transaction updateTransaction(int id, TransactionDto transactionDto) {
		limitCoast(transactionDto);
		Transaction transaction = findById(id);
		transaction.setCategory(categoryService.findById(transactionDto.getCategoryId()));
		transaction.setDescription(transactionDto.getDescription());
		//transaction.setCategory(transactionDto.getCategoryId());
		transaction.setType(transactionDto.getType());
		transaction.setValue(transactionDto.getValue());
		transaction.setObs(transactionDto.getObs());
		
		transactionRepository.save(transaction);
		
		return null;
	}

	public void deleteTransaction(int id) {
		transactionRepository.deleteById(id);
	}
	
	public void limitCoast(TransactionDto transactionDto) {
		if ("D".equals(transactionDto.getType())) {
			List<Transaction> listaNesteMesPorCategoria = buscarMesAtualPorCategoria(transactionDto.getCategoryId());
			String nomeCategoria = listaNesteMesPorCategoria.get(0).getCategory().getName();
			double limite = listaNesteMesPorCategoria.get(0).getCategory().getMaxSpending();
			double sum = listaNesteMesPorCategoria.stream().mapToDouble(m -> m.getValue()).sum();
			sum += transactionDto.getValue(); 
			
			if (sum >= limite) {
				throw new LimiteExcedidoException(
						"Limite de: " + limite + " para categoria: " + nomeCategoria + " atingido!");
			}
		}
	}
	//private final TransactionRepository ;
	
	//Transaction save (Transaction transaction);
	
	//List<Transaction> searchAll();
	
	//Transaction searchById(Integer id);
	
	//void remove(Integer id);
	
		
}
