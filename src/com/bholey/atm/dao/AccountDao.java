package com.bholey.atm.dao;

import java.util.List;

import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Transaction;

public interface AccountDao 
{
	public Transaction deposit(Account account,Double amount);
	public String withdraw(Account account,Double amount);
	public List<Transaction> miniStatement(Account account);
	
	
	
	

}
