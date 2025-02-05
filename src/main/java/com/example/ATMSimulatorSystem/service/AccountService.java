package com.example.ATMSimulatorSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ATMSimulatorSystem.dao.AccountRepository;
import com.example.ATMSimulatorSystem.entity.Account;
@Service
public class AccountService {
	 @Autowired
	 private AccountRepository accountRepository;
	 
	 
	 public Account openAccount(String accountHolderName, String pin) {
	        Account account = new Account();
	        account.setAccountHolderName(accountHolderName);
	        account.setAccountNumber("ACC" + System.currentTimeMillis());
	        account.setPin(pin);
	        account.setBalance(500.0);
	        return (Account) accountRepository.save(account);
	    }

	    public double checkBalance(String accountNumber, String pin) {
	        Account account = verifyAccount(accountNumber, pin);
	        return account.getBalance();
	    }

	    public Account deposit(String accountNumber, String pin, double amount) {
	        if (amount <= 0) {
	            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
	        }
	        Account account = verifyAccount(accountNumber, pin);
	        account.setBalance(account.getBalance() + amount);
	        return (Account) accountRepository.save(account);
	    }

	    public Account withdraw(String accountNumber, String pin, double amount) {
	        Account account = verifyAccount(accountNumber, pin);
	        if (amount <= 0 || amount > account.getBalance()) {
	            throw new IllegalArgumentException("Invalid withdrawal amount.");
	        }
	        account.setBalance(account.getBalance() - amount);
	        return (Account) accountRepository.save(account);
	    }

	    public Account changePin(String accountNumber, String oldPin, String newPin) {
	        Account account = verifyAccount(accountNumber, oldPin);
	        account.setPin(newPin);
	        return (Account) accountRepository.save(account);
	    }

	    private Account verifyAccount(String accountNumber, String pin) {
	        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber);
	        if (optionalAccount.isEmpty() || !optionalAccount.get().getPin().equals(pin)) {
	            throw new IllegalArgumentException("Invalid account number or PIN.");
	        }
	        return optionalAccount.get();
	    }
	    }
	
	
		 
	 


