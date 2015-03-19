package com.rahavoi.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rahavoi.entity.Employee;

/**
 * Session Bean implementation class ShoppingBean
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ShoppingBean {
	@PersistenceContext(unitName="EmployeeFactory")
	EntityManager em;

	public String getBeanInfo(){
		Employee emp = em.find(Employee.class, 1);
		return "ShoppingBean - Stateless Session Bean found employee " + emp.getName();
	}
}
