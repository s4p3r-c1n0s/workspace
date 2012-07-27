package com.neelam.training.spring.ioc.example4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CurrencyConverterClient {

	public void test() {
	
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example4/applicationContext.xml");
		CurrencyConverter curr = (CurrencyConverter) factory.getBean("currencyConverter");
		double rupees = curr.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees+" Rs.");		
	}
	
	public static void main(String args[]) throws Exception {
		(new CurrencyConverterClient()).test();
	}
}
