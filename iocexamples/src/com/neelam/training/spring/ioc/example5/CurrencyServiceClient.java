package com.neelam.training.spring.ioc.example5;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CurrencyServiceClient {

	public void test() {
		
		Resource res = new ClassPathResource("com/neelam/training/spring/ioc/example5/applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(res);
		CurrencyService curr = (CurrencyService) factory.getBean("currencyService");
		double rupees = curr.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees+" Rs.");
		CurrencyService curr2 = (CurrencyService) factory.getBean("currencyService");
		double rupees2 = curr2.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees2+" Rs.");		
	}
	
	public static void main(String args[]) {
		(new CurrencyServiceClient()).test();			
	}
}
