package com.example.ATMSimulatorSystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ATMSimulatorSystem.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	

	Optional<Account> findByAccountNumber(String accountNumber);

}
