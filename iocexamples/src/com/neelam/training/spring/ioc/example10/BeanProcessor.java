package com.neelam.training.spring.ioc.example10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanProcessor implements BeanPostProcessor {
	private int order;

	public int getOrder() {
	return order;
}

public void setOrder(int order) {
	this.order = order;
}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Second Processor :  after Initializing Bean '"+beanName+"'");
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		/*if(bean instanceof BaseDao)
			baseDao.setProperty(...);*/
		/*if(bean instanceof Auditable)
		baseDao.setProperty(...);*/
		System.out.println("Second Processor :  before initializing Bean '"+beanName+"'");
		return bean;
	}

	
}