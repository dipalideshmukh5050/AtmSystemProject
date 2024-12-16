package com.bholey.atm.presentation;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import com.bholey.atm.dao.MyConnection;
import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Card;
import com.bholey.atm.entity.Transaction;
import com.bholey.atm.service.AccountService;
import com.bholey.atm.service.AccountServiceImpl;
import com.bholey.atm.service.CardService;
import com.bholey.atm.service.CardServiceImpl;
import com.bholey.atm.validation.Validation;

public class AppImpl implements App
{
	Scanner scanner=new Scanner(System.in);
	EntityManager entityManager =MyConnection.getEntityManager();
	AccountService accountService=new AccountServiceImpl();
	CardService cardService=new CardServiceImpl(); 

	@Override
	public void deposit(Account account) 
	{
		Double amount=0.0;
		System.out.println("\t\t\t\t\t\t==================================================");
		System.out.println("\t\t\t\t\t\t\t\tDeposit Money.");
		System.out.println("\t\t\t\t\t\t==================================================");
		System.out.print("\n\t\t\t\t\t\tEnter Amount: ");
		amount =scanner.nextDouble();
		if(amount>0)
		{
			if(amount<=10000)
			{
				Transaction transaction =accountService.deposit(account, amount);
				if(transaction!=null)
				{
					System.out.println("\t\t\t\t\t\tTransaction successfull..");
					System.out.print("\t\t\t\t\t\tDo you want to display receipt(Y/N): ");
					Character choice=scanner.next().charAt(0);
					if(choice.equals('Y') || choice.equals('y'))
					{
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("\t\t\t===========================================================================================================");
						System.out.println("\t\t\t\t\t********************     Transaction Receipt.    ********************");
						System.out.println("\t\t\t===========================================================================================================");					
						System.out.printf("\n\t\t\t %-15s | %-15s | %-15s | %-15s | %-15s %n"," TransactionId","Transaction Amount","Transaction Date","Transaction Time","Transaction Type");
						System.out.println();
						System.out.println("\t\t\t===========================================================================================================");
						System.out.println();
						System.out.printf("\t\t\t %-15s | %-18s | %-16s | %-16s | %-14s %n", transaction.getTransactionId(),transaction.getTransactionAmount(),transaction.getTransactionDate(),transaction.getTransactionTime(),transaction.getTransactionType());
						System.out.println();
						System.out.println("\t\t\t===========================================================================================================");
					}	
				}
				else
				{
					System.out.println("\t\t\t\t\t\tTransaction unsucessfull");
				}
		    }
			else
			{
				System.out.println("\t\t\t\t\t\tYou can deposit only upto RS 10000 at a time");
			}
		
		}
		else
		{
			System.out.println("\t\t\t\t\t\tYou have entered invalid amount");
		}
		
	}

	@Override
	public void withdraw(Account account)
	{
		
		Integer multiple = 0;
		Double totalAmount = 0.0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("\t\t\t\t\t\t==================================================");
		System.out.println("\t\t\t\t\t\t\t\tWithdraw Money.");
		System.out.println("\t\t\t\t\t\t==================================================");
		System.out.println();
		System.out.printf("\t\t\t\t\t\t| %-10s | %-10s |%n", "1. 100 RS ","\t\t\t| 2. 200 Rs");
		System.out.println();
		System.out.printf("\t\t\t\t\t\t| %-10s | %-10s |%n", "3. 500 RS ","\t\t\t| 4. 2000 RS");
		System.out.println();
		System.out.printf("\t\t\t\t\t\t\t\t| %-10s |%n", "5. Exit");
		System.out.println();
		System.out.println("\t\t\t\t\t\t==================================================");
		System.out.println();
		System.out.print("\t\t\t\t\t\tSelect Operation :-");
		Integer cash=scanner.nextInt();
		
		switch(cash)
		{
		case 1:
			    System.out.print("\n\t\t\t\t\t\tEnter Amount as 100 *__ : ");
			    multiple = scanner.nextInt();
			    if(multiple>0)
			    {
			    	totalAmount = (double) (100*multiple);
				    if((account.getBalance()-1000)>totalAmount)
					{
						String msg=accountService.withdraw(account, totalAmount);
						if(msg.equals("Transaction successfull"))
						{
							System.out.println("\t\t\t\t\t\tDo you want to generate receipt(Y/N): ");
							Character choice = scanner.next().charAt(0);
							if(choice.equals('Y') || choice.equals('y'))
							{
								Transaction transaction=account.getTransaction().get(account.getTransaction().size()-1);
								System.out.println();
								System.out.println();
								System.out.println();
								System.out.println("\t\t\t===========================================================================================================");
								System.out.println("\t\t\t\t\t********************     Transaction Receipt.    ********************");
								System.out.println("\t\t\t===========================================================================================================");					
								System.out.printf("\n\t\t\t %-15s | %-15s | %-15s | %-15s | %-15s %n"," TransactionId","Transaction Amount","Transaction Date","Transaction Time","Transaction Type");
								System.out.println();
								System.out.println("\t\t\t===========================================================================================================");
								System.out.println();
								System.out.printf("\t\t\t %-15s | %-18s | %-16s | %-16s | %-14s %n", transaction.getTransactionId(),transaction.getTransactionAmount(),transaction.getTransactionDate(),transaction.getTransactionTime(),transaction.getTransactionType());
								System.out.println();
								System.out.println("\t\t\t===========================================================================================================");
							    break;
							}
							else
							{
								break;
							}
						}
						else
						{
							System.out.println("\t\t\t\t\t\t\t"+msg);
							break;
						}
					}
				    else
				    {
				    	System.out.println("\n\t\t\t\t\t\tInsufficient balance...!");
				    	break;
				    }
			    }
			    else
			    {
			    	System.out.println("\t\t\t\t\t\tYou have entered invalid amount..");
			    	break;
			    }
		case 2:
				System.out.print("\n\t\t\t\t\t\tEnter Amount as 200 *__ : ");
				multiple  = scanner.nextInt();
				
				 if(multiple>0)
				    {
				    	totalAmount = (double) (200*multiple);
					    if((account.getBalance()-1000)>totalAmount)
						{
					    	String msg=accountService.withdraw(account, totalAmount);
							if(msg.equals("Transaction successfull"))
							{
								System.out.println("\t\t\t\t\t\tDo you want to generate receipt(Y/N): ");
								Character choice = scanner.next().charAt(0);
								if(choice.equals('Y') || choice.equals('y'))
								{
									Transaction transaction=account.getTransaction().get(account.getTransaction().size()-1);
									System.out.println();
									System.out.println();
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
									System.out.println("\t\t\t\t\t********************     Transaction Receipt.    ********************");
									System.out.println("\t\t\t===========================================================================================================");					
									System.out.printf("\n\t\t\t %-15s | %-15s | %-15s | %-15s | %-15s %n"," TransactionId","Transaction Amount","Transaction Date","Transaction Time","Transaction Type");
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
									System.out.println();
									System.out.printf("\t\t\t %-15s | %-18s | %-16s | %-16s | %-14s %n", transaction.getTransactionId(),transaction.getTransactionAmount(),transaction.getTransactionDate(),transaction.getTransactionTime(),transaction.getTransactionType());
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
								    break;
								}
								else
								{
									break;
								}
							}
							else
							{
								System.out.println("\t\t\t\t\t\t"+msg);
								break;
							}
						}
					    else
					    {
					    	System.out.println("\n\t\t\t\t\t\tInsufficient balance...");
					    	break;
					    }
				    }
				    else
				    {
				    	System.out.println("\n\t\t\t\t\t\tYou have entered invalid amount..");
				    	break;
				    }
				 
		case 3:
				System.out.print("\n\t\t\t\t\t\tEnter Amount as 500 *__ : ");
				multiple  = scanner.nextInt();
				 if(multiple>0)
				    {
				    	totalAmount = (double) (500*multiple);
					    if((account.getBalance()-1000)>totalAmount)
						{
					    	String msg=accountService.withdraw(account, totalAmount);
							if(msg.equals("Transaction successfull"))
							{
								System.out.println("\t\t\t\t\t\tDo you want to generate receipt(Y/N): ");
								Character choice = scanner.next().charAt(0);
								if(choice.equals('Y') || choice.equals('y'))
								{
									Transaction transaction=account.getTransaction().get(account.getTransaction().size()-1);
									System.out.println();
									System.out.println();
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
									System.out.println("\t\t\t\t\t********************     Transaction Receipt.    ********************");
									System.out.println("\t\t\t===========================================================================================================");					
									System.out.printf("\n\t\t\t %-15s | %-15s | %-15s | %-15s | %-15s %n"," TransactionId","Transaction Amount","Transaction Date","Transaction Time","Transaction Type");
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
									System.out.println();
									System.out.printf("\t\t\t %-15s | %-18s | %-16s | %-16s | %-14s %n", transaction.getTransactionId(),transaction.getTransactionAmount(),transaction.getTransactionDate(),transaction.getTransactionTime(),transaction.getTransactionType());
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
								    break;
								}
								else
								{
									break;
								}
							}
							else
							{
								System.out.println("\t\t\t\t\t\t\t"+msg);
								break;
							}
						}
					    else
					    {
					    	System.out.println("\n\t\t\t\t\t\tInsufficient balance...");
					    	break;
					    }
				    }
				    else
				    {
				    	System.out.println("\n\t\t\t\t\t\tYou have entered invalid amount..");
				    	break;
				    }
		case 4:
				System.out.print("\n\t\t\t\t\t\tEnter Amount as 2000 *__ : ");
				multiple  = scanner.nextInt();
				 if(multiple>0)
				    {
				    	totalAmount = (double) (2000*multiple);
					    if((account.getBalance()-1000)>totalAmount)
						{
					    	String msg=accountService.withdraw(account, totalAmount);
							if(msg.equals("Transaction successfull"))
							{
								System.out.println("\t\t\t\t\t\tDo you want to generate receipt(Y/N): ");
								Character choice = scanner.next().charAt(0);
								if(choice.equals('Y') || choice.equals('y'))
								{
									Transaction transaction=account.getTransaction().get(account.getTransaction().size()-1);
									System.out.println();
									System.out.println();
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
									System.out.println("\t\t\t\t\t********************     Transaction Receipt.    ********************");
									System.out.println("\t\t\t===========================================================================================================");					
									System.out.printf("\n\t\t\t %-15s | %-15s | %-15s | %-15s | %-15s %n"," TransactionId","Transaction Amount","Transaction Date","Transaction Time","Transaction Type");
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
									System.out.println();
									System.out.printf("\t\t\t %-15s | %-18s | %-16s | %-16s | %-14s %n", transaction.getTransactionId(),transaction.getTransactionAmount(),transaction.getTransactionDate(),transaction.getTransactionTime(),transaction.getTransactionType());
									System.out.println();
									System.out.println("\t\t\t===========================================================================================================");
								    break;
								}
								else
								{
									break;
								}
							}
							else
							{
								System.out.println("\t\t\t\t\t\t"+msg);
								break;
							}
						}
					    else
					    {
					    	System.out.println("\n\t\t\t\t\t\tInsufficient balance...");
					    	break;
					    }
				    }
				    else
				    {
				    	System.out.println("\n\t\t\t\t\t\tYou have entered invalid amount..");
				    	break;
				    }
		case 5:
			break;
			default :
				System.out.println("\n\t\t\t\t\t\tYou have entered invalid choice....");
		}
		
	}

	@Override
	public void changePin(Card card) 
	{
		System.out.println("\t\t\t\t\t\t==================================================");
		System.out.println("\t\t\t\t\t\t\t\tChange Pin.");
		System.out.println("\t\t\t\t\t\t==================================================");
		Boolean flagPin,flagAll;
		flagPin=flagAll=true;
		while(flagAll)
		{
			System.out.print("\n\t\t\t\t\t\tEnter new PIN:");
			String newPin=scanner.next();
			
			if(Validation.isFour(newPin))
			{
				if(Validation.checkNumericCardNo(newPin) && Validation.notZero(newPin))
				{
					if(!card.getPin().equals(newPin))
					{
						flagAll=false;
						while(flagPin)
						{
							System.out.print("\n\t\t\t\t\t\tConfirm new PIN: ");
							String confirmPin=scanner.next();
							if(Validation.isFour(confirmPin))
							{
								if(Validation.checkNumericCardNo(confirmPin) && Validation.notZero(confirmPin))
								{
									if(newPin.equals(confirmPin))
									{
										flagPin=false;
										System.out.println("\t\t\t\t\t\t"+cardService.changePin(card, confirmPin));
									}
									else
									{
										System.out.println("\n\t\t\t\t\t\tNew Pin and confirm Pin does not match");
									}
								}
								else
								{
									System.out.println("\n\t\t\t\t\t\tPlease enter non-zero numeric value");
								}
							}
							else
							{
								System.out.println("\n\t\t\t\t\t\tPin should be of only 4-digits");
							}
						}
					}
					else
					{
						System.out.println("\n\t\t\t\t\t\tNew Pin should not be same as old pin");
					}
				}
				else
				{
					System.out.println("\n\t\t\t\t\t\tPlease enter non-zero numeric value");
				}
			}
			else
			{
				System.out.println("\n\t\t\t\t\t\tPlease enter 4-digit Pin");
			}
		}
	}

	@Override
	public void checkBalance(Account account) 
	{
		System.out.println("\t\t\t\t\t\t==================================================");
		System.out.printf("\n\t\t\t\t\t\t\t %-20s %f ","Available Balance :  ",account.getBalance());	
		System.out.println("\n\n\t\t\t\t\t\t==================================================");
	}

	@Override
	public void miniStatement(Account account) 
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\t\t=================================================================================================================");
		System.out.println("\t\t\t\t *********************     Mini Statement.     *********************");
		System.out.println("\t\t=================================================================================================================");
		System.out.printf("\n\t\t %-20s | %-20s | %-20s | %-20s | %-20s %n"," TransactionId","Transaction Amount","Transaction Date","Transaction Time","Transaction Type");
		System.out.println();
		System.out.println("\t\t=================================================================================================================");
		System.out.println();
		
		List<Transaction> list=accountService.miniStatement(account);
		Iterator<Transaction> itr=list.iterator();
		while(itr.hasNext())
		{
			Transaction transaction=itr.next();
			System.out.printf("\t\t %-20s | %-20s | %-20s | %-20s | %-20s %n", transaction.getTransactionId(),transaction.getTransactionAmount(),transaction.getTransactionDate(),transaction.getTransactionTime(),transaction.getTransactionType());
			System.out.println();
			System.out.println("\t\t=================================================================================================================");	
		}
		
		
	}


}
