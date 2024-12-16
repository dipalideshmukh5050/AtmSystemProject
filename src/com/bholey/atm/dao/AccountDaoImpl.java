package com.bholey.atm.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.bholey.atm.entity.Account;
import com.bholey.atm.entity.Transaction;


public class AccountDaoImpl implements AccountDao 
{
	private EntityManager entityManager=MyConnection.getEntityManager();
	private EntityTransaction entityTransaction;

	@Override
	public Transaction deposit(Account account, Double amount) 
	{
		entityTransaction=entityManager.getTransaction();
		Double balance=account.getBalance();
		
		Transaction transaction = new Transaction();
		transaction.setTransactionType("CR");
		transaction.setTransactionAmount(amount);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionTime(LocalTime.now());
		transaction.setAccount(account);
		
		entityTransaction.begin();
		account.setBalance(balance+amount);
	    entityManager.persist(transaction);
	    entityTransaction.commit();
	    
		return transaction;
		
	}

	@Override
	public String withdraw(Account account, Double amount) 
	{
		entityTransaction=entityManager.getTransaction();
		String jpql="select sum(t.transactionAmount),count(t.transactionId) from Transaction t where t.account.accountNo=:ACCOUNT and t.transactionType=:TYPE and t.transactionDate=:DATE";
		Query query=entityManager.createQuery(jpql);
		String accountNo=account.getAccountNo();
		query.setParameter("ACCOUNT",accountNo);
		query.setParameter("TYPE", "DR");
		query.setParameter("DATE", LocalDate.now());
		List<Object[]> listResult = query.getResultList();
		Iterator<Object[]> itr1=listResult.iterator();
		Double totalWithdrawalAmount = 0.0;
		Long limitWithdraw = 0l;
		while(itr1.hasNext())
		{
			Object o[]=itr1.next(); 
			totalWithdrawalAmount=(Double) o[0];
			limitWithdraw=(Long) o[1];
			//totalWithdrawalAmount =  (double) o[0];
			//limitWithdraw= (int) o[1];	
		}
		if(totalWithdrawalAmount == null)
		{
			totalWithdrawalAmount = 0.0;
		}
		if(limitWithdraw<3)
		{
			if(totalWithdrawalAmount<30000 && (totalWithdrawalAmount+amount)<=30000)
			{
				Double balance=account.getBalance();
				Transaction transaction = new Transaction();
				transaction.setTransactionType("DR");
				transaction.setTransactionAmount(amount);
				transaction.setTransactionDate(LocalDate.now());
			    transaction.setTransactionTime(LocalTime.now());
			    transaction.setAccount(account);
				
				entityTransaction.begin();
				account.setBalance(balance-amount);
			    entityManager.persist(transaction);
			    entityTransaction.commit();
			    return "Transaction successfull";
			}
			else
			{
				return "You have excided withdrawal limit";
			}
			
		}
		else
		{
			return "You can withdraw money only three times per day";
			
		}
	
	}

	@Override
	public List<Transaction> miniStatement(Account account) 
	{
		String jpql ="select t from Transaction t where t.account.accountNo =:Account order by t.transactionDate desc";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("Account", account.getAccountNo());
		query.setMaxResults(10);
		List<Transaction> transactionList = query.getResultList();
		return transactionList;
	}
	

}
