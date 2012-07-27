package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


public class Employee{

	private String name;
	private int empId;
	private double salary;
	
	private Address address;

	public Address getAddress() {
		return address;
	}

	@Autowired
	@Qualifier("add")
		public void setAddress(Address address) {
		System.out.println("Setter");
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee(Address add){
		this.address = add;
	}
	public Employee(String name, int empId, double salary,Address add) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
		this.address=add;
	
	}
	public Employee() {
		super();
	}
	
	
		
}
