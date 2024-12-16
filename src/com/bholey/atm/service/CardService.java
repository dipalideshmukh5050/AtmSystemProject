package com.bholey.atm.service;
import com.bholey.atm.entity.Card;

public interface CardService 
{
	public Card checkCardNo(String cardNo);
	public String blockCard(String cardNo);
	public String changePin(Card card, String confirmPin);

}
