package com.jsp.PaymentWalletApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.PaymentWalletApp.Dto.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	
}