package com.neelam.training.spring.ioc.example10;


import org.springframework.context.ApplicationEvent;

public class CustomApplicationEvent extends ApplicationEvent {
	
	public CustomApplicationEvent(Object source) {
		super(source);
	}
}
