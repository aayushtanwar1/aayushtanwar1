package com.cg.user.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private EntityManagerFactory entityManagerFactory;
	EntityManager entityManager ;
	
	public EntityManager getEntityManager()
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	
	
	public void closeEntityManager()
	{
	entityManager.close();
	entityManagerFactory.close();
	}
}
