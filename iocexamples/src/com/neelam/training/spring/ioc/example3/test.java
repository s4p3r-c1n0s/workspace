package com.neelam.training.spring.ioc.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	/**
	 * @param args
	 */
	public void get(){
		
		ApplicationContext factory = new 
			ClassPathXmlApplicationContext(new String[]{"com/neelam/training/spring/ioc/example3/applicationContext.xml", "com/neelam/training/spring/ioc/example3/applicationContext1a.xml"});
		CurrencyConverter curr = (CurrencyConverter) factory.getBean("currencyConverter");
		double d = curr.dollarsToRupees(30);
		System.out.println(d);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test().get();
	}

}
