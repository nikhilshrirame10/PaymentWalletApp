package com.jsp.PaymentWalletApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.PaymentWalletApp.Dao.AccountDao;
import com.jsp.PaymentWalletApp.Dto.Account;
import com.jsp.PaymentWalletApp.Dto.User;
import com.jsp.PaymentWalletApp.repository.AccountRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AccountService {
	
	@Autowired
	AccountDao dao;

	public Account saveAccount(Account account , HttpSession session) {
		if(account != null & session != null)
		{
			User user= (User) session.getAttribute("user");
			account.setAmount(account.getInitialBal());
			account.setUser(user);
			Account account2 = (Account)dao.saveAccount(account);
			if(account2 != null)
			{
				session.setAttribute("account", account2);
				return account2;
			}
		}
		return null;

	}

	public List<Account> getAllAccount() {
		return dao.getAllAccount();
	}

	public Account getByAccountId(int id) {
		
		return dao.getByAccountId(id);
	}

	public Account deleteAccount(int id) {
		
		return dao.deleteAccount(id);
	}

	public Account updateAccount(Account account) {
		
		return dao.updateAccount(account);
	}
	public Account sendAmount(double amt,HttpSession session)
	{
		if(amt>0)
		{
			Account account = (Account)session.getAttribute("account");
			if(account != null)
			{
				double res = account.getAmount() - amt;
				if(account.getAmount() >amt)
				{
					account.setAmount(res);
					return dao.updateAccount(account);
				}
			}
		}
		return null;
	}
	public Account receiveAmount(double amt,HttpSession session)
	{
		if(amt>0)
		{
			Account account = (Account)session.getAttribute("account");
			if(account != null)
			{
				double res = account.getAmount() + amt;
				account.setAmount(res);
				return dao.updateAccount(account);
			}
		}
		return null;
	}
	public Account displayAmount( HttpSession session)
	{
		Account account = (Account)session.getAttribute("account");
		if(account != null)
		{
			
			return dao.getByAccountId(account.getId());
		}
		return null;
	}

}
