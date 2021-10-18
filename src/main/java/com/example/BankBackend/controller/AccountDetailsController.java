package com.example.BankBackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankBackend.exception.ResourceNotFoundException;
import com.example.BankBackend.model.AccountDetails;
import com.example.BankBackend.repository.AccountRepository;

@CrossOrigin(origins = "http://localhost:3000/")
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
	
	// create account rest api
	@PostMapping("/accountdetails")
	public AccountDetails createAccount(@RequestBody AccountDetails accountdetails) {
		return accountRepository.save(accountdetails);
	}
	
	//get employee by id rest api
	@GetMapping("/accountdetails/{id}")
	public ResponseEntity<AccountDetails> getAccountById(@PathVariable long id) {
		AccountDetails accountdetails = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
		return ResponseEntity.ok(accountdetails);
	}
	
	// update account rest API 
	@PutMapping("/accountdetails/{id}")
	public ResponseEntity<AccountDetails> updateAccount(@PathVariable long id, @RequestBody AccountDetails accountupdate){
		AccountDetails accountdetails = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
		accountdetails.setName(accountupdate.getName());
		accountdetails.setMobileNumber(accountupdate.getMobileNumber());
		accountdetails.setAccountType(accountupdate.getAccountType());
		accountdetails.setAccountNumber(accountupdate.getAccountNumber());
		accountdetails.setBalance(accountupdate.getBalance());
		accountdetails.setCurrency(accountupdate.getCurrency());
		
		AccountDetails updatedAccount = accountRepository.save(accountdetails);
		return ResponseEntity.ok(updatedAccount);
	}
	
	// delete employee rest API
	@DeleteMapping("/accountdetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAccount(@PathVariable long id){
		AccountDetails accountdetails = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
		accountRepository.delete(accountdetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);  
	
	}
	
}
