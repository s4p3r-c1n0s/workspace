package com.umang.common.HiberSpring;
import javax.persistence.*;
@Entity
@Table(name="customer")
public class Customer {
	@Id
	private String firstName;
	private String lastName;
	private int phoneNumber;
}
