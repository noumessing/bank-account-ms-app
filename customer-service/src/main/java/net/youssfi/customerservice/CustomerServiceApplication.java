package net.youssfi.customerservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import net.youssfi.customerservice.config.GlobalConfig;
import net.youssfi.customerservice.entities.Customer;
import net.youssfi.customerservice.repository.CustomerRepository;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		
		return args -> {
			
			/*
			 * Customer customer1 = Customer.builder() .firstName("Hassan")
			 * .lastName("Elhoumi") .email("hassan@gmail.com") .build();
			 * customerRepository.save(customer1);
			 * 
			 * Customer customer2 = Customer.builder() .firstName("Mohamed")
			 * .lastName("Youssfi") .email("mohamed@gmail.com") .build();
			 * 
			 * customerRepository.save(customer2);
			 */
		
			List<Customer> customerList= List.of(Customer.builder()
													.firstName("Hassan")
													.lastName("Elhoumi")
													.email("hassan@gmail.com")
													.build(),
												Customer.builder()
													.firstName("Mohamed")
													.lastName("Youssfi")
													.email("mohamed@gmail.com")
													.build());
			
			customerRepository.saveAll(customerList);
		};
		
	}

}
