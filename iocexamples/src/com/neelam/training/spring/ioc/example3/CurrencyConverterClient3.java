package com.neelam.training.spring.ioc.example3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CurrencyConverterClient3 {

	public void test() {
		
		ApplicationContext pfactory = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example3/applicationContext1b.xml");
		ApplicationContext cfactory = 
			new ClassPathXmlApplicationContext(new String[]{"com/neelam/training/spring/ioc/example3/applicationContext1aa.xml"}, pfactory);
		CurrencyConverter curr = (CurrencyConverter) cfactory.getBean("currencyConverter");
		double rupees = curr.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees+" Rs.");		
	}
	
	public static void main(String args[]) throws Exception {
		(new CurrencyConverterClient3()).test();
	}
}
