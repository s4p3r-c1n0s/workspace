package com.neelam.training.spring.ioc.example10;


import java.util.Properties;

public class SomeServiceClass {

	private Properties adminEmails;

	public SomeServiceClass() {
	}

	public Properties getAdminEmails() {
		return adminEmails;
	}

	public void setAdminEmails(Properties adminEmails) {
		this.adminEmails = adminEmails;
	}
	
	
}
