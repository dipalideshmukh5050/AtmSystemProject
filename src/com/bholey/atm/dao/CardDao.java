package com.bholey.atm.dao;

import com.bholey.atm.entity.Card;

public interface CardDao 
{
	public Card checkCardNo(String cardNo);
	public String blockCard(String cardNo);
	public String changePin(Card card, String confirmPin);
	
	

}
