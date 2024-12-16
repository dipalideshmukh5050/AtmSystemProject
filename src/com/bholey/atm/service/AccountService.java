package com.bholey.atm.service;

import java.util.List;

import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Transaction;

public interface AccountService 
{
	public Transaction deposit(Account account,Double amount);
	public String withdraw(Account account,Double amount);
	public List<Transaction> miniStatement(Account account);
	

}
