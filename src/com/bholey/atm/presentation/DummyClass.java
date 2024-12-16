package com.bholey.atm.presentation;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.bholey.atm.dao.MyConnection;
import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Bank;
import com.bholey.atm.entity.Card;
import com.bholey.atm.entity.Customer;

public class DummyClass 
{
	public static void main(String args[]) 
	{
		EntityManager entityManager=MyConnection.getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		List<Customer>list = new ArrayList<Customer>();
		List<Account>list1 = new ArrayList<Account>();
		List<Card>list2 = new ArrayList<Card>();
		
		Bank bank=new Bank();
		
		Customer customer=new Customer();
		Customer customer1=new Customer();
		Customer customer2=new Customer();
		
		
		Account account1=new Account();
		Account account2=new Account();
		
		Card card=new Card();
		Card card1=new Card();
		
		bank.setBankName("Bank of Baroda");
		bank.setIfscCode("BARB0JALGAO");
		bank.setCustomer(list);
		bank.setHelpLine("18005700");
		bank.setBranchName("Jalgaon");
	
		customer.setCustomerId("R7M024653");
		customer.setCustomerName("Vaishali Vanjari");
		customer.setCustomerAddress("Erandol");
		customer.setEmail("vaishalivanjari@gmail.com");
		customer.setDob(LocalDate.parse("1970-12-01"));
		customer.setGender('F');
		customer.setMobile("9176069283");
		customer.setAadharCard("957429547621");
		customer.setPanCard("KPPDY9677H");
		customer.setBank(bank);
		customer.setAccount(list1);
		list.add(customer);
		
		
		customer1.setCustomerId("L1P926567");
		customer1.setCustomerName("Deepak Patil");
		customer1.setCustomerAddress("Jalgaon");
		customer1.setEmail("deepakpatil@gmail.com");
		customer1.setDob(LocalDate.parse("1973-12-01"));
		customer1.setGender('M');
		customer1.setMobile("7709811787");
		customer1.setAadharCard("678234765433");
		customer1.setPanCard("LPIFW5487H");
		customer1.setBank(bank);
		customer1.setAccount(list1);
		list.add(customer1);
		
		customer2.setCustomerId("N9A065749");
		customer2.setCustomerName("Kajal Patil");
		customer2.setCustomerAddress("Jalgaon");
		customer2.setEmail("kajolpatil@gmail.com");
		customer2.setDob(LocalDate.parse("2001-11-05"));
		customer2.setGender('F');
		customer2.setMobile("7448069283");
		customer2.setBank(bank);
		customer2.setAadharCard("651316919342");
		customer2.setPanCard("FUNPP9751H");
		customer2.setAccount(list1);
		list.add(customer2);
		
		account1.setAccountNo("04800100025871");
		account1.setAccountType("Saving");
		account1.setBalance(10000.00);
		account1.setCustomer(customer2);
		account1.setOpeningDate(LocalDate.parse("2019-05-29"));
		account1.setAccountStatus("active");
		account1.setCard(list2);
		list1.add(account1);
		
		account2.setAccountNo("04800100023124");
		account2.setAccountType("Current");
		account2.setBalance(10000.00);
		account2.setCustomer(customer2);
		account2.setOpeningDate(LocalDate.parse("2022-11-03"));
		account2.setAccountStatus("active");
		list1.add(account2);
		
		Account account7=new Account();
		Account account8=new Account();
		
		account7.setAccountNo("76540100023985");
		account7.setAccountType("Saving");
		account7.setBalance(10000.00);
		account7.setCustomer(customer);
		account7.setOpeningDate(LocalDate.parse("2020-10-13"));
		account7.setAccountStatus("active");
		list1.add(account7);
		
		account8.setAccountNo("92584100023909");
		account8.setAccountType("Current");
		account8.setBalance(10000.00);
		account8.setCustomer(customer1);
		account8.setOpeningDate(LocalDate.parse("2023-10-03"));
		account8.setAccountStatus("active");
		list1.add(account8);
		
		card.setCardNo("7865234515296498");
		card.setCvv("516");
		card.setExpiryDate(LocalDate.parse("2025-07-13"));
		card.setIssueDate(LocalDate.parse("2019-05-30"));
		card.setPin("9311");
		card.setType("DebitCard");
		card.setStatus("active");
		card.setAccount(account1);
		list2.add(card);
		
		card1.setCardNo("7213675419021673");
		card1.setCvv("927");
		card1.setExpiryDate(LocalDate.parse("2027-02-26"));
		card1.setIssueDate(LocalDate.parse("2023-12-04"));
		card1.setPin("7342");
		card1.setType("ATMCard");
		card1.setStatus("active");
		card1.setAccount(account1);
		list2.add(card1);
		
		Card card6=new Card();
		Card card7=new Card();
		Card card8=new Card();
		
		card6.setCardNo("3746244515209923");
		card6.setCvv("246");
		card6.setExpiryDate(LocalDate.parse("2025-07-13"));
		card6.setIssueDate(LocalDate.parse("2021-05-03"));
		card6.setPin("7613");
		card6.setType("DebitCard");
		card6.setStatus("active");
		card6.setAccount(account7);
		list2.add(card6);
		
		card7.setCardNo("9163075419021673");
		card7.setCvv("647");
		card7.setExpiryDate(LocalDate.parse("2026-02-07"));
		card7.setIssueDate(LocalDate.parse("2022-12-04"));
		card7.setPin("7342");
		card7.setType("ATMCard");
		card7.setStatus("active");
		card7.setAccount(account8);
		list2.add(card7);
		
		card8.setCardNo("8653675419021043");
		card8.setCvv("922");
		card8.setExpiryDate(LocalDate.parse("2027-02-26"));
		card8.setIssueDate(LocalDate.parse("2023-11-04"));
		card8.setPin("8942");
		card8.setType("ATMCard");
		card8.setStatus("active");
		card8.setAccount(account2);
		list2.add(card8);
		
		
		
		//sbibank
		
		List<Customer>list3 = new ArrayList<Customer>();
		List<Account>list4 = new ArrayList<Account>();
		List<Card>list5 = new ArrayList<Card>();
		
        Bank bank1=new Bank();
		
		Customer customer3=new Customer();
		Customer customer4=new Customer();
		Customer customer5=new Customer();
		
		Account account3=new Account();
		Account account4=new Account();
		
		Card card2=new Card();
		Card card3=new Card();
		
		bank1.setBankName("State Bank of India");
		bank1.setIfscCode("SBIN0021467");
		bank1.setCustomer(list3);
		bank1.setHelpLine("18001234");
		bank1.setBranchName("Dhule");
		
		customer3.setCustomerId("90589320270");
		customer3.setCustomerName("Sakshi Sukreja");
		customer3.setCustomerAddress("Shirpur");
		customer3.setEmail("sakshik123@gmail.com");
		customer3.setDob(LocalDate.parse("2002-08-08"));
		customer3.setGender('F');
		customer3.setMobile("7558286999");
		customer3.setAadharCard("377560487378");
		customer3.setPanCard("KELPK8143H");
		customer3.setBank(bank1);
		customer3.setAccount(list4);
		list3.add(customer3);
		
		customer4.setCustomerId("92341088612");
		customer4.setCustomerName("Bhagyashri Patil");
		customer4.setCustomerAddress("Dhule");
		customer4.setEmail("bhagyashri3@gmail.com");
		customer4.setDob(LocalDate.parse("2002-01-07"));
		customer4.setGender('F');
		customer4.setMobile("9878286999");
		customer4.setAadharCard("904011013889");
		customer4.setPanCard("GCDPP9787E");
		customer4.setAccount(list4);
		customer4.setBank(bank1);
		list3.add(customer4);
		
		customer5.setCustomerId("92341087492");
		customer5.setCustomerName("Deepak Patil");
		customer5.setCustomerAddress("Jalgaon");
		customer5.setEmail("deepakpatil@gmail.com");
		customer5.setDob(LocalDate.parse("1973-12-01"));
		customer5.setGender('M');
		customer5.setMobile("7709811787");
		customer5.setAadharCard("345610937645");
		customer5.setPanCard("DHLWC0235H");
		customer5.setBank(bank1);
		customer5.setAccount(list4);
		list3.add(customer5);
		
		account3.setAccountNo("39481962959");
		account3.setAccountType("Saving");
		account3.setBalance(30000.00);
		account3.setCustomer(customer4);
		account3.setAccountStatus("active");
		account3.setOpeningDate(LocalDate.parse("2020-07-16"));
		account3.setCard(list5);
		list4.add(account3);
		
		account4.setAccountNo("23171962959");
		account4.setAccountType("Current");
		account4.setBalance(12000.00);
		account4.setCustomer(customer5);
		account4.setAccountStatus("active");
		account4.setOpeningDate(LocalDate.parse("2019-10-02"));
		account4.setCard(list5);
		list4.add(account4);
		
		Account account9=new Account();
		
		account9.setAccountNo("90781962912");
		account9.setAccountType("Current");
		account9.setBalance(12000.00);
		account9.setCustomer(customer3);
		account9.setOpeningDate(LocalDate.parse("2023-10-08"));
		account9.setAccountStatus("active");
		account9.setCard(list5);
		list4.add(account9);
		
		card2.setCardNo("6513675413629674");
		card2.setCvv("677");
		card2.setExpiryDate(LocalDate.parse("2025-07-16"));
		card2.setIssueDate(LocalDate.parse("2018-03-04"));
		card2.setPin("6652");
		card2.setType("DebitCard");
		card2.setStatus("active");
		card2.setAccount(account3);
		list5.add(card2);
		
		card3.setCardNo("8763675411639209");
		card3.setCvv("827");
		card3.setExpiryDate(LocalDate.parse("2026-02-16"));
		card3.setIssueDate(LocalDate.parse("2020-10-04"));
		card3.setPin("9832");
		card3.setType("ATMCard");
		card3.setStatus("active");
		card3.setAccount(account9);
		list5.add(card3);
		
		Card card9=new Card();
		card9.setCardNo("7863475411691123");
		card9.setCvv("937");
		card9.setExpiryDate(LocalDate.parse("2025-02-19"));
		card9.setIssueDate(LocalDate.parse("2021-07-04"));
		card9.setPin("4804");
		card9.setType("ATMCard");
		card9.setStatus("active");
		card9.setAccount(account4);
		list5.add(card9);
		
		
		//cbibank
		
		List<Customer>list6 = new ArrayList<Customer>();
		List<Account>list7= new ArrayList<Account>();
		List<Card>list8 = new ArrayList<Card>();
		
        Bank bank2=new Bank();
		
		Customer customer6=new Customer();
		Customer customer7=new Customer();
		Customer customer8=new Customer();
		
		Account account5=new Account();
		Account account6=new Account();
		
		Card card4=new Card();
		Card card5=new Card();
		
		bank2.setBankName("Central Bank of India");
		bank2.setIfscCode("CBIN0283782");
		bank2.setCustomer(list6);
		bank2.setHelpLine("18002021911");
		bank2.setBranchName("Nashik");
		
		customer6.setCustomerId("5YB065149");
		customer6.setCustomerName("Riddhi Bhavsar");
		customer6.setCustomerAddress("Nandurbar");
		customer6.setEmail("riddhib76@gmail.com");
		customer6.setDob(LocalDate.parse("2002-10-27"));
		customer6.setGender('F');
		customer6.setMobile("9130736422");
		customer6.setAadharCard("308759304004");
		customer6.setPanCard("DJSPB2498P");
		customer6.setBank(bank2);
		customer6.setAccount(list7);
		list6.add(customer6);
		
		customer7.setCustomerId("R2T983421");
		customer7.setCustomerName("Bhagyashri Bhamare");
		customer7.setCustomerAddress("Dhule");
		customer7.setEmail("bhagyashribh@gmail.com");
		customer7.setDob(LocalDate.parse("2002-05-07"));
		customer7.setGender('F');
		customer7.setMobile("7385013295");
		customer7.setAadharCard("439079304004");
		customer7.setPanCard("RFHUB2498P");
		customer7.setBank(bank2);
		customer7.setAccount(list7);
		list6.add(customer7);
		
		customer8.setCustomerId("90724041659");
		customer8.setCustomerName("Dipali Deshmukh");
		customer8.setCustomerAddress("Risod");
		customer8.setEmail("dipali9619@gmail.com");
		customer8.setDob(LocalDate.parse("2002-05-05"));
		customer8.setGender('F');
		customer8.setMobile("9619348018");
		customer8.setAadharCard("752052323249");
		customer8.setPanCard("GWDPD7658J");
		customer8.setBank(bank2);
		customer8.setAccount(list7);
		list6.add(customer8);
		
		account5.setAccountNo("39995685493");
		account5.setAccountType("Saving");
		account5.setBalance(32320.00);
		account5.setCustomer(customer8);
		account5.setAccountStatus("active");
		account5.setOpeningDate(LocalDate.parse("2018-07-06"));
		account5.setCard(list8);
		list7.add(account5);
		
		account6.setAccountNo("04788100007132");
		account6.setAccountType("Current");
		account6.setBalance(212000.00);
		account6.setCustomer(customer6);
		account6.setAccountStatus("active");
		account6.setOpeningDate(LocalDate.parse("2022-04-02"));
		account6.setCard(list8);
		list7.add(account6);
		
		Account account10=new Account();
		account10.setAccountNo("4041434180");
		account10.setAccountType("Saving");
		account10.setBalance(32320.00);
		account10.setCustomer(customer7);
		account10.setAccountStatus("active");
		account10.setOpeningDate(LocalDate.parse("2018-07-06"));
		account10.setCard(list8);
		list7.add(account10);
		
		card4.setCardNo("3180375413629674");
		card4.setCvv("632");
		card4.setExpiryDate(LocalDate.parse("2025-08-29"));
		card4.setIssueDate(LocalDate.parse("2014-03-04"));
		card4.setPin("9243");
		card4.setType("DebitCard");
		card4.setStatus("active");
		card4.setAccount(account6);
		list8.add(card4);
		
		card5.setCardNo("9125105411639246");
		card5.setCvv("013");
		card5.setExpiryDate(LocalDate.parse("2020-06-26"));
		card5.setIssueDate(LocalDate.parse("2015-05-03"));
		card5.setPin("2503");
		card5.setType("DebitCard");
		card5.setStatus("active");
		card5.setAccount(account5);
		list8.add(card5);
		
		entityTransaction.begin();
			entityManager.persist(bank);
			entityManager.persist(bank1);
			entityManager.persist(bank2);
		entityTransaction.commit();
		System.out.println("added..");
		
	}
}


