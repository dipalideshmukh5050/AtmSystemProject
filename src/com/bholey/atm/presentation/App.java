package com.bholey.atm.presentation;

import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Card;

public interface App 
{
	void deposit(Account account);
	void withdraw(Account account);
	void changePin(Card card);
	void checkBalance(Account account);
	void miniStatement(Account account);
}
