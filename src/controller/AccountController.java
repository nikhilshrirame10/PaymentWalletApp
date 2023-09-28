package com.jsp.PaymentWalletApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.PaymentWalletApp.Dto.Account;
import com.jsp.PaymentWalletApp.Service.AccountService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@RestController
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@PostMapping("/accounts")
	public Account saveAccount(@RequestBody Account account , HttpSession session) {
		return service.saveAccount(account , session);

	}
	@GetMapping("/accounts")
	public List<Account> getAllAccount() {
		return service.getAllAccount();
	}
	
	@GetMapping("/accounts/{id}")
	public Account getByAccountId(@PathVariable int id) {
		
		return service.getByAccountId(id);
	}
	@DeleteMapping("/accounts/{id}")
	public Account deleteAccount(@PathVariable int id) {
		
		return service.deleteAccount(id);
	}
	
	@PutMapping("/accounts")
	public Account updateAccount(@RequestBody Account account) {
		
		return service.updateAccount(account);
	}
	
	@PatchMapping("/accounts/{amt}")
	public Account sendAmount(@PathVariable double amt,HttpSession session)
	{
		return service.sendAmount(amt, session);
	}
	@PatchMapping("/accounts")
	public Account receiveAmount(@RequestParam double amt, HttpSession session)
	{
		return service.receiveAmount(amt, session);
	}
	@GetMapping("/accounts/display")
	public Account displayAmount(HttpSession session)
	{
		return service.displayAmount(session);
	}

	

}
