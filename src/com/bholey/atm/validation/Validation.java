package com.bholey.atm.validation;

public class Validation 
{
	public static Boolean isSixteen(String cardNo) 
	{
		if(cardNo.length()!=16) 
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	public static Boolean isFour(String pin) 
	{
		if(pin.length()!=4)
		{
			return false;
		}
		return true;
	}
	
	public static Boolean notZero(String card) 
	{
			Long no= Long.parseLong(card);
			if(no==0) 
			{
				return false;
			}
			else 
			{
				return true;
			}		
	}
	public static Boolean checkNumericCardNo(String cardNo)
	{
			Boolean status = true;
			char []card = cardNo.toCharArray();
			for(int i = 0; i<card.length; i++)
			{
					if(card[i]>=48 && card[i] <= 57)
					{
						status = true;
					}
					else
					{
						status = false;
					}
			}
			return status;
	}
	
	

}
