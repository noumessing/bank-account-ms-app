package net.youssfi.accountservice.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.youssfi.accountservice.enums.AccountType;
import net.youssfi.accountservice.model.Customer;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
	@Id
	private String accountId;
	private double balance;
	private LocalDate createAt;
	private String currency;
	@Enumerated(EnumType.STRING)
	private AccountType type;
	@Transient
	private Customer customer;
	private Long  customerId;
}
