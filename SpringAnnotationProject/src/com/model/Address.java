package com.model;

public class Address {
private String state;
private String country;

public Address() {
	System.out.println("Address Constructor");
}
public Address(String state, String country) {
	super();
	this.state = state;
	this.country = country;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}


}
