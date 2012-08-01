package com.umang.common.HiberSpring;
import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long gethNo() {
		return hNo;
	}
	public void sethNo(long hNo) {
		this.hNo = hNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Id
	private long hNo;
	private String city;
	private String state; 
	private int zip;
}
