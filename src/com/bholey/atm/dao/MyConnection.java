package com.bholey.atm.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyConnection
{
	private MyConnection() {}
	private static EntityManager entityManager;
	
	public static EntityManager getEntityManager()
	{
			if(entityManager==null)
			{
					EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("atm");
					entityManager = entityManagerFactory.createEntityManager();
			}
			return entityManager;
	}

}
