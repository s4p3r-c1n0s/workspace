package com.neelam.training.spring.ioc.example8;

import java.util.Date;

public class SomeProcessing {

	private Date startDate;
	private Date endDate;
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public void doSomething() {
		System.out.println("startDate : "+startDate);
		System.out.println("endDate : "+endDate);
	}
	
}
