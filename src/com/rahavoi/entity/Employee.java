package com.rahavoi.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Access(AccessType.FIELD)
@Table(name="EMPLOYEE")
public class Employee {
	/**
	 * By default all fields are loaded eagerly. 
	 * This can be overriden setting fetch="FetchType.LAZY" value of the @Basic annotation. See 'salary' field.
	 * Lazy loading is not guaranteet though. Persistence provider may ignore it. :(
	 * In practice it is almost never a good idea to lazily fetch simple types.
	 * 
	 * The only times when lazy loading of a basic mapping should be considered are when
	   there are many columns in a table (for example, dozens or hundreds) or when the columns are large
	   (for example, very large character strings or byte strings). It could take significant resources to load the
	   data, and not loading it could save quite a lot of effort, time, and resources. Unless either of these two
	   cases is true, in the majority of cases lazily fetching a subset of object attributes will end up being more
	   expensive than eagerly fetching them.

	 * FetchType.Eager cannot be ignored by the persistence provider.
	 * 
	 * @javax.persistence.Lob annotation is used for fetching large objects
	 * There are two types of large objects: CLOBS and BLOBS
	 * BLOB - binary large object
	 * CLOB - character large object
	 * 
	 * LOBs may be good candidates for lazy loading.
	 * 
	 * Enums may be mapped using @Enumerated annotation:
	 * @Enumerated(EnumType.Ordinal) <-- used by default. gets converted to the integer (based on the natural order of the enum value) when persisting. Considered bad approach 
	 * @Enumerated(EnumType.String) <-- String representation of the enum
	 */
	
	@TableGenerator(name="Emp_Gen",
			table="ID_GEN",
			pkColumnName="GEN_NAME",
			valueColumnName="GEN_VAL",
			pkColumnValue="Emp_Gen",
			initialValue=1000,
			allocationSize=10)
	@Id @GeneratedValue(generator="Emp_Gen")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="name")//Excessive. no need in this annotation if the attribute name matches the column name.
	private String name;
	
	@Basic(fetch=FetchType.LAZY)
	@Column(name="salary")
	private long salary;
	
	public Employee(){}

	public Employee(int id){
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(long salary) {
		this.salary = salary;
	}
}
