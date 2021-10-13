package com.example.BankBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BankBackend.model.AccountDetails;

@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long>{

}
 