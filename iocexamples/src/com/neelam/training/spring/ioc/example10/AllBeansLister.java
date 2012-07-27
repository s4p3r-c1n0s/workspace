package com.neelam.training.spring.ioc.example10;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class AllBeansLister implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
		//factory.configureBean(arg0, arg1)
		System.out.println("the factory contains the following beans:");
		String[] beanNames = factory.getBeanDefinitionNames();
		
		for(int i=0;i<beanNames.length;i++)
			System.out.println(beanNames[i]);
	}	
}
