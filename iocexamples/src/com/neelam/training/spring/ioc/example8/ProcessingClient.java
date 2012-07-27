package com.neelam.training.spring.ioc.example8;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProcessingClient {

	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example8/applicationContext.xml");	
		SomeProcessing sp = (SomeProcessing) ctx.getBean("someProcessing");
		sp.doSomething();	
	}
	
	public static void main(String args[]) {
		(new ProcessingClient()).test();
	}
}
