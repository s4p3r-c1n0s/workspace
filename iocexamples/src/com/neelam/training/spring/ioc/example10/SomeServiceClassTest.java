package com.neelam.training.spring.ioc.example10;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SomeServiceClassTest {

	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example10/applicationContext2.xml");
		SomeServiceClass sc = (SomeServiceClass) ctx.getBean("serviceClass");
		Properties p = sc.getAdminEmails();
		p.list(System.out);
	}
	
	public static void main(String args[]) {
		(new SomeServiceClassTest()).test();
	}
}
