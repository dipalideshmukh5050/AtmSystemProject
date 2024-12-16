package com.bholey.atm.presentation;
import java.util.Scanner;

import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Card;
import com.bholey.atm.service.CardService;
import com.bholey.atm.service.CardServiceImpl;
import com.bholey.atm.validation.Validation;

public class Login 
{
	private static CardService cardService= new CardServiceImpl();
	private static Card card;
	private static Account account;
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("\t\t\t=============================================================================================");
		System.out.println("\t\t\t\t\t****************       WELCOME TO ATM       ****************");                                                            
		System.out.println("\t\t\t=============================================================================================");
		System.out.println();
		System.out.println("\t\t\t\t\t\t============================================");
		System.out.println("\t\t\t\t\t\t\t\t   Login ");
		System.out.println("\t\t\t\t\t\t============================================");
		Boolean flag=true;
		while(flag) 
		{	System.out.println();
			System.out.print("\n\t\t\t\t\t\tEnter Card No:");
			String cardNo= scanner.next();
			if(Validation.checkNumericCardNo(cardNo))  
			{
				if(Validation.isSixteen(cardNo))
				{
					if(Validation.notZero(cardNo))
					{
						card=cardService.checkCardNo(cardNo);
						if(card!=null)
						{
							if(card.getStatus().equals("blocked"))
							{
								System.out.println("\n\t\t\t\t\t\tYour card is Blocked please contact your bank");
							}
							else
							{
								int attempt=3;
								while(attempt-->0) 
								{
									System.out.print("\n\t\t\t\t\t\tEnter pin:");
									String pin = scanner.next();
									if(Validation.isFour(pin)) 
									{
										if(Validation.checkNumericCardNo(pin))
										{
											if(Validation.notZero(pin))
											{
												String checkPin=card.getPin();
												if(checkPin.equals(pin))
												{
													MainApp.getWelcomePage(card);
													flag=false;
													break;
												}
												else
												{
													if(attempt==0) 
													{
														flag=false;
														System.out.println("\n\t\t\t\t\t\t"+cardService.blockCard(cardNo));
														break;
													}
													else
													{
														System.out.println("\n\t\t\t\t\t\tPin does not match");
													}
												}
											}
											else
											{
												if(attempt==0) 
												{
													flag=false;
													System.out.println("\n\t\t\t\t\t\t"+cardService.blockCard(cardNo));
													break;
												}
												else
												{
													System.out.println("\n\t\t\t\t\t\tEnter non-zero value for pin...");
												}
											}
											
										}
										else
										{
											if(attempt==0) 
											{
												flag=false;
												System.out.println("\n\t\t\t\t\t\t"+cardService.blockCard(cardNo));
												break;
											}
											else
											{
												System.out.println("\n\t\t\t\t\t\tEnter numeric value for pin...");
											}
										}	
								    }
									else
									{
										if(attempt==0) 
										{
											flag=false;
											System.out.println("\n\t\t\t\t\t\t"+cardService.blockCard(cardNo));
											
											break;
										}
										else
										{
											System.out.println("\n\t\t\t\t\t\tPlease enter 4-digits numeric value...");
										}
									}
								}
							}
						}
						else
						{
							System.out.println("\n\t\t\t\t\t\tCard number is not linked with any account ");
						}		
					}
					else
					{
						System.out.println("\n\t\t\t\t\t\tEnter non zero card number...");
					}		
				}
				else
				{
					System.out.println("\n\t\t\t\t\t\tEnter valid 16-digit card number");
				}
			}
			else 
			{
				System.out.println("\n\t\t\t\t\t\tEnter numeric value only");
			}
		}
	}

}
