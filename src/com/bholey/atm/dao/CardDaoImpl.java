package com.bholey.atm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bholey.atm.entity.Card;

public class CardDaoImpl implements CardDao
{
     private EntityManager entityManager=MyConnection.getEntityManager();
     private Card card;

	@Override
	public Card checkCardNo(String cardNo) 
	{
	    card=entityManager.find(Card.class,cardNo);
		if(card!=null)
		{
			return card;
		}
		return card;
	}

	@Override
	public String blockCard(String cardNo) 
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		card=entityManager.find(Card.class,cardNo);
		if(card!=null)
		{
			entityTransaction.begin();
			card.setStatus("blocked");
			entityTransaction.commit();
			return "Your card is blocked due to more attempts of wrong pin please visit your bank";
		}
		return "Your card is blocked please visit your bank";
	}

	@Override
	public String changePin(Card card, String confirmPin) 
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(card!=null)
		{
			entityTransaction.begin();
			card.setPin(confirmPin);
			entityTransaction.commit();
			return "Pin set successfully";
		}
		
		
		return "Please try again later!";
	}

	

}
