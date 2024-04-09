package net.youssfi.accountservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.youssfi.accountservice.model.Customer;

@FeignClient(name = "CUSTOMER-SERVICE" )
public interface CustomerRestClient {
	
	@GetMapping("/customers/{id}")
	@CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
	Customer findCustomerById(@PathVariable Long id);
	
	@GetMapping("/customers")
	@CircuitBreaker(name = "customerService", fallbackMethod ="getAllCustomers" )
	List<Customer> allCustomer();
	
	default Customer getDefaultCustomer(Long id,Exception exception) {
		
		Customer customer = new Customer();
		
		customer.setId(id);
		customer.setFirstName("Not Available");
		customer.setLastName("Not Available");
		customer.setEmail("Not Available");
		
		return customer;
		
	}
	
	default List<Customer> getAllCustomers(Exception exception){
		
		return List.of();
	}

}
