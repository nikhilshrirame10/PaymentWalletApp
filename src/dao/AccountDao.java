package com.jsp.PaymentWalletApp.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.PaymentWalletApp.Dto.Account;
import com.jsp.PaymentWalletApp.Dto.Account;
import com.jsp.PaymentWalletApp.Dto.Account;
import com.jsp.PaymentWalletApp.repository.AccountRepository;

@Repository
public class AccountDao {

	@Autowired
	AccountRepository repository;

	public Account saveAccount(Account account) {
		return repository.save(account);

	}

	public List<Account> getAllAccount() {
		return repository.findAll();
	}

	public Account getByAccountId(int id) {
		Optional<Account> optional = repository.findById(id);
		return optional.get();
	}

	public Account deleteAccount(int id) {
		Optional<Account> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.delete(optional.get());
		}
		return optional.get();
	}

	public Account updateAccount(Account account) {
		Optional<Account> optional = repository.findById(account.getId());
		if (optional.isPresent()) {
			repository.save(account);
		}
		return optional.get();
	}

}
