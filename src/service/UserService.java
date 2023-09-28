package com.jsp.PaymentWalletApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.PaymentWalletApp.Dao.UserDao;
import com.jsp.PaymentWalletApp.Dto.Login;
import com.jsp.PaymentWalletApp.Dto.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User saveUser(User user)
	{
		return userDao.saveUser(user);
	}
	public List<User> getAllUser()
	{
		return userDao.getAllUser();
	}
	public User getByUserId(int id)
	{
		return userDao.getByUserId(id);
		
	}
	public User deleteUser(int id)
	{
		return userDao.deleteUser(id);
	}
	public User updateUser(User user)
	{
		return userDao.updateUser(user);
	}
	public User loginuser(Login login , HttpServletRequest request )
	{
		HttpSession session = request.getSession();
		User user = userDao.loginUser(login);
		if(user != null)
		{
			session.setAttribute("user", user);
		}
		return user;
	}
	

}
