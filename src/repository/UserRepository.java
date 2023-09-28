package com.jsp.PaymentWalletApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.PaymentWalletApp.Dto.Login;
import com.jsp.PaymentWalletApp.Dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where email=:email and password=:password")
	public User validationUser(@RequestParam String email ,@RequestParam String password);

	
	
	

}
