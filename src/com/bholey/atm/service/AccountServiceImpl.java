package com.bholey.atm.service;

import java.util.List;

import com.bholey.atm.dao.AccountDao;
import com.bholey.atm.dao.AccountDaoImpl;
import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Transaction;

public class AccountServiceImpl implements AccountService
{
	private AccountDao accountDao=new AccountDaoImpl();

	@Override
	public Transaction deposit(Account account, Double amount) 
	{
		return accountDao.deposit(account, amount);
	}


	@Override
	public String withdraw(Account account, Double amount)
	{
		return accountDao.withdraw(account, amount);
	}


	@Override
	public List<Transaction> miniStatement(Account account) {
		
		return accountDao.miniStatement(account);
	}
	

}
