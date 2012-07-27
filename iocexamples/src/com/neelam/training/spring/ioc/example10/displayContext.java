package com.neelam.training.spring.ioc.example10;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class displayContext implements ApplicationContextAware{
	 private ApplicationContext ctx;

	    public void setApplicationContext(ApplicationContext applicationContext)
	            throws BeansException {
	        ctx = applicationContext;
	    }
	
 

 public void displayAppContext() {
 	 System.out.println(ctx);
     System.out.println(ctx.getBeanDefinitionCount());

     
     
 }
}
