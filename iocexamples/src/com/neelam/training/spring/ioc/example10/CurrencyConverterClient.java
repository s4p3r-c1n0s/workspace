package com.neelam.training.spring.ioc.example10;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class CurrencyConverterClient {

	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example10/applicationContext.xml");	CurrencyConverter curr = (CurrencyConverter) ctx.getBean("currencyConverter");
		double rupees = curr.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees+" Rs.");
		//try { System.in.read(); } catch(Exception e) { }
	ctx.close();
	}
	
	public static void main(String args[]) {
		(new CurrencyConverterClient()).test();
	}
}







