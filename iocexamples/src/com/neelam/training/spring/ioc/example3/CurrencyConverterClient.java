package com.neelam.training.spring.ioc.example3;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CurrencyConverterClient {

	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example3/applicationContext.xml");
		CurrencyConverter curr = (CurrencyConverter) ctx.getBean("currencyConverter");
		double rupees = curr.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees+" Rs.");		
	}
	
	public static void main(String args[]) throws Exception {
		(new CurrencyConverterClient()).test();
	}
}
