package com.neelam.training.spring.ioc.common;

public class Flight {

	private String flightNo;
	private String carrier;
	private String from;
	private String to;
	
	public Flight(){
		
		
	}
	
	
	public Flight(String flightNo, int carrier) {
		super();
		this.flightNo = flightNo;
	}


	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	
}
