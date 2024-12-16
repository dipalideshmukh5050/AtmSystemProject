package com.bholey.atm.presentation;
import java.util.Scanner;
import com.bholey.atm.entity.Card;

public class MainApp
{
	public static void getWelcomePage(Card card) 
	{
		Scanner scanner = new Scanner(System.in);
		Integer choice = 0;
	    Boolean flag=true;
		App app = new AppImpl();	
		while(flag)
	    {
	    	System.out.println();
	    	System.out.println();
	    	System.out.println();
	    	System.out.println("\t===================================================================================================================================");
			System.out.println("\t\t\t*****************************       WELCOME TO ATM SYSTEM      *****************************");                                                            
			System.out.println("\t===================================================================================================================================");
			System.out.println();
			System.out.printf("\tBank : "+card.getAccount().getCustomer().getBank().getBankName()+ "\t\t\t\t\t\t\t\t\t\t HelpLine No :- "+card.getAccount().getCustomer().getBank().getHelpLine());

			System.out.println("\n\n\t\t\t\t\t\t\tWelcome :"+card.getAccount().getCustomer().getCustomerName()+"...!!");
			System.out.println("\n\n\tAccount no : "+card.getAccount().getAccountNo());
		
			System.out.println();
			System.out.println();
			System.out.println("\t\t\t\t===============================================================================");
			System.out.println("\t\t\t\t\t\t\tDear customer, please select Transaction");
			System.out.println("\t\t\t\t===============================================================================");
			System.out.println();
			
			
			
			System.out.printf("\t\t\t\t| %-25s | %-25s |%n", "1. Deposit Money ","\t\t\t\t| 2. Withdraw Money");
			System.out.println();
			System.out.printf("\t\t\t\t| %-25s | %-25s |%n", "3. Mini Statement ","\t\t\t\t| 4. Check Balance");
			System.out.println();
			System.out.printf("\t\t\t\t| %-25s | %-25s |%n", "5. Change pin ","\t\t\t\t| 6. Exit");
			System.out.println();
			System.out.println("\t\t\t\t===============================================================================");
			System.out.println();
			System.out.print("\t\t\t\tSelect Operation :-");
			choice = scanner.nextInt();
			System.out.println();
			
			
			switch(choice)
			{
				case 1:
					app.deposit(card.getAccount());
					break;
					
				case 2:
					app.withdraw(card.getAccount());
					break;
				case 3:
					app.miniStatement(card.getAccount());
					break;
				case 4:
					app.checkBalance(card.getAccount());
					break;
				case 5:
					app.changePin(card);
					break;
				case 6:
					flag=false;
					System.out.println("\t\t\t\t\t\t===========================================");
					System.out.println("\t\t\t\t\t\t\tThank you for visiting our ATM");
					System.out.println("\t\t\t\t\t\t===========================================");
					break;
				default:
					System.out.println("Invalid choice");		
				
			}
	    }
		

			
	}

}
