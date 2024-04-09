package net.youssfi.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.youssfi.accountservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
