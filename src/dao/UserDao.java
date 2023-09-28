package com.jsp.PaymentWalletApp.Dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.PaymentWalletApp.Dto.Login;
import com.jsp.PaymentWalletApp.Dto.User;
import com.jsp.PaymentWalletApp.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);

	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getByUserId(int id) {
		Optional<User> optional = userRepository.findById(id);
		return optional.get();
	}

	public User deleteUser(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			userRepository.delete(optional.get());
		}
		return optional.get();
	}

	public User updateUser(User user) {
		Optional<User> optional = userRepository.findById(user.getId());
		if (optional.isPresent()) {
			userRepository.save(user);
		}
		return optional.get();
	}

	public User loginUser(Login login) {
		return userRepository.validationUser(login.getEmail(), login.getPassword());

	}

}
