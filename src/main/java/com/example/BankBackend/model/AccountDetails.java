package com.example.BankBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccountDetails")
public class AccountDetails {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
 
 @Column(name = "Name")
 private String name;
 
 @Column(name = "MobileNumber")
 private int mobileNumber;
 
 @Column(name = "AccountType")
 private String accountType;
 
 @Column(name = "AccountNumber")
 private int accountNumber;
 
 @Column(name = "Balance")
 private double balance;
 
 @Column(name = "Currency")
 private String currency;
 
 public AccountDetails() {
	 
 }


public AccountDetails(String name, int mobileNumber, String accountType, int accountNumber, double balance,
		String currency) {
	super();
	this.name = name;
	this.mobileNumber = mobileNumber;
	this.accountType = accountType;
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.currency = currency;
}


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public int getMobileNumber() {
	return mobileNumber;
}


public void setMobileNumber(int mobileNumber) {
	this.mobileNumber = mobileNumber;
}


public String getAccountType() {
	return accountType;
}


public void setAccountType(String accountType) {
	this.accountType = accountType;
}


public int getAccountNumber() {
	return accountNumber;
}


public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}


public double getBalance() {
	return balance;
}


public void setBalance(double balance) {
	this.balance = balance;
}


public String getCurrency() {
	return currency;
}


public void setCurrency(String currency) {
	this.currency = currency;
}

 
 
 
}
