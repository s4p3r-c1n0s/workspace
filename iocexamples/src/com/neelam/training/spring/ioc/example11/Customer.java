package com.neelam.training.spring.ioc.example11;

public class Customer {

	
private String name;
private int age;
private Address address;



public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public Customer() {
	super();
}

public Customer(int age, String name) {
	super();
	this.age = age;
	this.name = name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}


}
