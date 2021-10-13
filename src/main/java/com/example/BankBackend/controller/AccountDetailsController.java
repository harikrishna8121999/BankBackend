package com.example.BankBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankBackend.model.AccountDetails;
import com.example.BankBackend.repository.AccountRepository;

@RestController
@RequestMapping("/api/v1/")
public class AccountDetailsController {

	@Autowired
	private AccountRepository accountRepository;
	
	//get all accounts
	@GetMapping("/accountdetails")
	public List<AccountDetails> getAllAccountDetails(){
		return accountRepository.findAll();
	}
}
