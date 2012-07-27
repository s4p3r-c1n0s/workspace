package com.neelam.training.spring.ioc.example5;

public abstract class CurrencyServiceImpl implements CurrencyService {
	
	public CurrencyServiceImpl() {
		System.out.println("CurrencyServiceImpl()");
	}

	public abstract StockService getStockService();

	public double dollarsToRupees(double dollars) {
		System.out.println("dollarsToRupees()");
		StockService service = getStockService();
		double exchangeRate = service.getExchangeRate();
		return dollars * exchangeRate;
	}
};






