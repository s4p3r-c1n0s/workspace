package com.neelam.training.spring.ioc.example2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;



public class CurrencyConverterClient {

	public void test() {
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example2/applicationContext.xml");
		//BeanFactory factory = new XmlBeanFactory(res);
		CurrencyConverter curr = (CurrencyConverter) factory.getBean("currencyConverter");
		double rupees = curr.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees+" Rs.");
	}
	
	
	public static void main(String args[]) throws Exception {
		(new CurrencyConverterClient()).test();
	}
}
