package net.youssfi.accountservice;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import net.youssfi.accountservice.clients.CustomerRestClient;
import net.youssfi.accountservice.entities.BankAccount;
import net.youssfi.accountservice.enums.AccountType;
import net.youssfi.accountservice.repository.BankAccountRepository;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository accountRepository,CustomerRestClient customerRestClient) {
		
		return  args ->{
			
			customerRestClient.allCustomer().forEach(c -> {
				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("EUR")
						.balance(Math.random()*8000)
						.createAt(LocalDate.now())
						.type(AccountType.CURRENT_ACCOUNT)
						.customerId(c.getId())
						.build();
				BankAccount bankAccount2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("EUR")
						.balance(Math.random()*5000)
						.createAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();
				accountRepository.save(bankAccount1);
				accountRepository.save(bankAccount2);
				
			});
			
			/*
			 * BankAccount bankAccount1 = BankAccount.builder()
			 * .accountId(UUID.randomUUID().toString()) .currency("EUR") .balance(9800)
			 * .createAt(LocalDate.now()) .type(AccountType.CURRENT_ACCOUNT)
			 * .customerId(Long.valueOf(1)) .build(); BankAccount bankAccount2 =
			 * BankAccount.builder() .accountId(UUID.randomUUID().toString())
			 * .currency("EUR") .balance(1200) .createAt(LocalDate.now())
			 * .type(AccountType.SAVING_ACCOUNT) .customerId(Long.valueOf(2)) .build();
			 * 
			 * accountRepository.save(bankAccount1); accountRepository.save(bankAccount2);
			 */
			
			
		} ;
		
	}

}
