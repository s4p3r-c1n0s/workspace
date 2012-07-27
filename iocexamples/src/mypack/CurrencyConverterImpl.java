package mypack;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CurrencyConverterImpl implements CurrencyConverter,
BeanNameAware,
		BeanFactoryAware,DisposableBean, InitializingBean{
	

	@Override
	public void setBeanName(String arg0) {
		System.out.println("setBeanName()");
		
	}

	public CurrencyConverterImpl() {
		System.out.println("CurrencyConverterImpl()");
	}

	private double exchangeRate;

	public void setExchangeRate(double exchangeRate) {
		System.out.println("setExchangeRate()");
		this.exchangeRate = exchangeRate;
	}

	public double dollarsToRupees(double dollars) {
		System.out.println("dollarsToRupees()");
		return dollars * exchangeRate;
	}

	public void setBeanFactory(BeanFactory factory) {
		System.out.println("setBeanFactory");

	}
	
	public void setup() {
		System.out.println("custom init-method");
	}

	public void cleanup() {
		System.out.println("custom destroy-method");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");

	}

	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	
};







