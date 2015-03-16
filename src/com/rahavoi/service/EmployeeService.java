package com.rahavoi.service;

import java.util.List;

import javax.ejb.Local;

import com.rahavoi.entity.Employee;

@Local
public interface EmployeeService {
	public Employee createEmployee(int id, String name, long salary);
	public void removeEmployee(int id);
	public Employee changeEmployeeSalary(int id, long newSalary);
	public Employee findEmployee(int id);
	public List<Employee> findAllEmployees();
}
