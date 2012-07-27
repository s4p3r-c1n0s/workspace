package com.neelam.training.spring.ioc.example2;

public class CurrencyConverterImpl implements CurrencyConverter {

	private double exchangeRate;

	public CurrencyConverterImpl(double exchangeRate) {
		System.out.println("CurrencyConverterImpl(double)");
		this.exchangeRate = exchangeRate;
	}

	public double dollarsToRupees(double dollars) {
		System.out.println("dollarsToRupees()");		
		return dollars * exchangeRate;
	}
};