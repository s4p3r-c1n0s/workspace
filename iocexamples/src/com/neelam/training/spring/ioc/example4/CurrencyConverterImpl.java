package com.neelam.training.spring.ioc.example4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CurrencyConverterImpl 
implements CurrencyConverter, ApplicationContextAware {

	private String exchangeServiceName;
	private ApplicationContext applicationContext;
	
	public void setExchangeServiceName(String exchangeServiceName) {
		this.exchangeServiceName = exchangeServiceName;
	}

	public double dollarsToRupees(double dollars) {
		ExchangeService exchangeService = (ExchangeService)applicationContext.getBean(exchangeServiceName);
		return dollars * exchangeService.getExchangeRate();
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;		
	}
	
	public CurrencyConverterImpl() {
		System.out.println("CurrencyConverterImpl()");
	}

};
