package net.youssfi.accountservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.youssfi.accountservice.clients.CustomerRestClient;
import net.youssfi.accountservice.entities.BankAccount;
import net.youssfi.accountservice.model.Customer;
import net.youssfi.accountservice.repository.BankAccountRepository;

@RestController
public class AccountRestController {
	
	private BankAccountRepository accountRepository;
	
	private CustomerRestClient customerRestClient;

	
	public AccountRestController(BankAccountRepository accountRepository,CustomerRestClient customerRestClient) {
			this.accountRepository = accountRepository;
			this.customerRestClient = customerRestClient;
			
	}
	
	@GetMapping("/accounts")
	public List<BankAccount> accountList(){
		
		List<BankAccount> accountList= accountRepository.findAll();
		
		accountList.forEach(acc ->{
			Customer customer = customerRestClient.findCustomerById(acc.getCustomerId());
			acc.setCustomer(customer);
			
		});
		
		return accountList;
		
		//return accountRepository.findAll();
		
	}
	
	@GetMapping("/accounts/{id}")
	public BankAccount bankAccountById(@PathVariable String id) {
		
		BankAccount   bankAccount = accountRepository.findById(id).get();
		Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
		bankAccount.setCustomer(customer);
		return bankAccount;
		
		//return accountRepository.findById(id).get();
	}

}
