package com.neelam.training.spring.ioc.example1;


public class CurrencyConverterImpl implements CurrencyConverter {

	private double exchangeRate;
	
	public CurrencyConverterImpl() {
		System.out.println("CurrencyConverterImpl()");
	}

	public void setExchangeRate(double exchangeRate) {
		System.out.println("setExchangeRate()");
		this.exchangeRate = exchangeRate;
	}

	public double dollarsToRupees(double dollars) {
		System.out.println("dollarsToRupees()");
		return dollars * exchangeRate;
	}
};