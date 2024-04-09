package net.youssfi.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import net.youssfi.customerservice.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
