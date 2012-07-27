package mypack;

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
		System.out.println("Second Processor :  before initializing Bean '"+beanName+"'");
		return bean;
	}

	
}