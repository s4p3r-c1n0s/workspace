package com.neelam.training.spring.ioc.example10;


import java.util.TimerTask;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomApplicationEventPublisher extends TimerTask implements
		ApplicationEventPublisherAware {

	public void run() {
		CustomApplicationEvent event = new CustomApplicationEvent(this);
		eventPublisher.publishEvent(event);
	}

	private ApplicationEventPublisher eventPublisher;

	public void setApplicationEventPublisher(
			org.springframework.context.ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
}




