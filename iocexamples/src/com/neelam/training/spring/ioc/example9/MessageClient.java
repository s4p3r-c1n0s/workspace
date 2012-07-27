package com.neelam.training.spring.ioc.example9;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageClient {

	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example9/applicationContext.xml");
		MessageSource messageSource = (MessageSource) ctx.getBean("messageSource");
		Locale locale = new Locale("fr","FR");//Locale.getDefault();
		Object arr[] = {"Neelam", "Lets go to Haridwar"};
		String msg = messageSource.getMessage("welcome.message",arr,locale);
		System.out.println(msg);	
	}
	
	public static void main(String args[]) {
		(new MessageClient()).test();
	}
}






