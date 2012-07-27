package com.neelam.training.spring.ioc.example3;

public class CurrencyConverterImpl implements CurrencyConverter {

	private ExchangeService exchangeService;
	//private Employee emp;
	int var;
	public CurrencyConverterImpl() {
		System.out.println("CurrencyConverterImpl()");
	}
	public CurrencyConverterImpl(int c) {
		var =c;
		System.out.println("CurrencyConverterImpl(var)");
	}
	public void setExchangeService(ExchangeService exchangeService) {
		System.out.println("setExchangeService()");
		this.exchangeService = exchangeService;
	}

	public double dollarsToRupees(double dollars) {
		System.out.println("dollarsToRupees()" + var);
		return dollars * exchangeService.getExchangeRate();
	}
};
