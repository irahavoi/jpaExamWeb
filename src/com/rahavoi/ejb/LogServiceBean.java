package com.rahavoi.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.rahavoi.entity.LogRecord;

/**
 * Example of using Resource-local transactions in the Java EE Environment
 * for logging purposes (logs must be kept even if JTA transactions fail)  
 */
@Stateless
@LocalBean
public class LogServiceBean {
	@PersistenceUnit(unitName = "logging")
	private EntityManagerFactory emf;
	
	public void log(int userid, String action){
		EntityManager em = emf.createEntityManager();
		
		try{
			LogRecord lr = new LogRecord(userid, action);
			em.getTransaction().begin();
			em.persist(lr);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
