package com.neelam.training.spring.ioc.example3;

public class ExchangeServiceImpl implements ExchangeService {

	public ExchangeServiceImpl() {
		System.out.println("ExchangeServiceImpl()");
	}
	public double getExchangeRate() {
		System.out.println("getExchangeRate()");
		return 44.25;
	}
}
