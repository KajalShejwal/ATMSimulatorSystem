package com.example.ATMSimulatorSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ATMSimulatorSystem.entity.Account;
import com.example.ATMSimulatorSystem.service.AccountService;
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	private AccountService accountservice;

	@PostMapping("/open")
    public Account openAccount(@RequestParam String accountHolderName, @RequestParam String pin) {
        return accountservice.openAccount(accountHolderName, pin);
    }

    @GetMapping("/balance")
    public double checkBalance(@RequestParam String accountNumber, @RequestParam String pin) {
        return accountservice.checkBalance(accountNumber, pin);
    }

    @PostMapping("/deposit")
    public Account deposit(@RequestParam String accountNumber, @RequestParam String pin, @RequestParam double amount) {
        return accountservice.deposit(accountNumber, pin, amount);
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam String accountNumber, @RequestParam String pin, @RequestParam double amount) {
        return accountservice.withdraw(accountNumber, pin, amount);
        
    }

    @PutMapping("/change-pin")
    public Account changePin(@RequestParam String accountNumber, @RequestParam String oldPin, @RequestParam String newPin) {
        return accountservice.changePin(accountNumber, oldPin, newPin);
    }
}


