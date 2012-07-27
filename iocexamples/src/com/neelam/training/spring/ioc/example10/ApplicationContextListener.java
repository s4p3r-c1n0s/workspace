package com.neelam.training.spring.ioc.example10;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationContextListener implements ApplicationListener, 
ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	public void onApplicationEvent(ApplicationEvent evt) {
		System.out.println("onApplicationEvent" + evt.getTimestamp());
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

	
}
