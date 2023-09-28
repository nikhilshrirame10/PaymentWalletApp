package com.jsp.PaymentWalletApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.PaymentWalletApp.Dto.Login;
import com.jsp.PaymentWalletApp.Dto.User;
import com.jsp.PaymentWalletApp.Service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {


	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	@GetMapping("/users/{id}")
	public User getByUserId(@PathVariable int id)
	{
		return userService.getByUserId(id);
		
	}
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id)
	{
		return userService.deleteUser(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user);
	}
	
	@GetMapping("/users/login")
	public User loginUser(@RequestBody Login login, HttpServletRequest request)
	{
		return userService.loginuser(login, request);
		
	}
}
