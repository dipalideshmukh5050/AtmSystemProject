package com.bholey.atm.service;

import com.bholey.atm.dao.CardDao;
import com.bholey.atm.dao.CardDaoImpl;
import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Card;
import com.bholey.atm.entity.Customer;

public class CardServiceImpl implements CardService
{
	private CardDao cardDao=new CardDaoImpl();
    
	@Override
	public Card checkCardNo(String cardNo) 
	{
		return cardDao.checkCardNo(cardNo) ;
	}

	@Override
	public String blockCard(String cardNo) 
	{
		return cardDao.blockCard(cardNo);
	}

	@Override
	public String changePin(Card card, String confirmPin) 
	{
		return cardDao.changePin(card, confirmPin);
	}

}
