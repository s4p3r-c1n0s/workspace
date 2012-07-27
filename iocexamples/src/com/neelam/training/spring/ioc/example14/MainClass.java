package com.neelam.training.spring.ioc.example14;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example14/applicationContext.xml");
		Manager m = (Manager)ctx.getBean("manager");
		m.display();
		
	}
	
	public static void main(String args[]) {
		(new MainClass()).test();
	}
}
