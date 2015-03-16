package com.rahavoi.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rahavoi.entity.Employee;
import com.rahavoi.service.EmployeeService;

/**
 * Session Bean implementation class EmployeeServiceBean
 */
@Stateless
@LocalBean
public class EmployeeServiceBean  implements EmployeeService{
	@PersistenceContext(unitName="EmployeeFactory")
	private EntityManager em;

	@Override
	public Employee createEmployee(int id, String name, long salary) {
		Employee emp = new Employee(id);
		emp.setName(name);
		emp.setSalary(salary);
		em.persist(emp);
		
		return emp;
	}

	@Override
	public void removeEmployee(int id) {
		Employee emp = findEmployee(id);
		
		if(emp != null){
			em.remove(emp);
		}
	}

	@Override
	public Employee changeEmployeeSalary(int id, long newSalary) {
		Employee emp = findEmployee(id);
		
		if(emp != null){
			emp.setSalary(newSalary);
		}
		return emp;
	}

	@Override
	public Employee findEmployee(int id) {
		return em.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return em.createQuery("SELECT e FROM Employee e", Employee.class)
		.getResultList();
	}
	
	
    

}
