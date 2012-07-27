package com.neelam.training.spring.ioc.example3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CurrencyConverterClient2 {

	public void test() {
		
		ApplicationContext factory = new 
			ClassPathXmlApplicationContext(new String[]{"com/neelam/training/spring/ioc/example3/applicationContext1a.xml", "com/neelam/training/spring/ioc/example3/applicationContext1b.xml"});
		CurrencyConverter curr = (CurrencyConverter) factory.getBean("currencyConverter");
		double rupees = curr.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees+" Rs.");		
	}
	
	public static void main(String args[]) throws Exception {
		(new CurrencyConverterClient2()).test();
	}
}
