package com.neelam.training.spring.ioc.example11;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;

public class ValidationClient {

	public void test() {
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example11/applicationContext.xml");
		Customer customer = (Customer)ctx.getBean("customer");
	
		
		
		CustomerValidator validatorTest =(CustomerValidator)ctx.getBean("validate2");
		
		DataBinder binder = new DataBinder(customer);
		BindingResult result = binder.getBindingResult();
		validatorTest.validate(customer, result);
		
		
		if(result.getErrorCount()>0){
			System.out.println("Error");
				 List r = result.getAllErrors();
				 Iterator iterator = r.iterator();
				 while(iterator.hasNext()){
					 FieldError e =(FieldError)iterator.next();
					 System.out.println(e.getDefaultMessage());
			}
		}
		
		else{
		
		System.out.println(customer.getAge());
		System.out.println(customer.getName());
		}
	}
	public static void main(String[] args) {
		(new ValidationClient()).test();

	}

}
