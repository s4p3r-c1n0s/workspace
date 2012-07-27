package com.neelam.training.spring.ioc.example1;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CurrencyConverterClient {

	public void test() {
		Resource res = new ClassPathResource("com/neelam/training/spring/ioc/example1/applicationContext.xml");
		XmlBeanFactory ctx = new XmlBeanFactory(res);
		ctx.destroySingleton("currencyConverter");
		
		/*String packageName = PackageInfo.getPackageNameAsPath(this);
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(packageName+"applicationContext1b.xml");
		*/CurrencyConverter curr = (CurrencyConverter) ctx.getBean("currencyConverter");
		double rupees = curr.dollarsToRupees(50.0);
		System.out.println("50 $ is "+rupees+" Rs.");

		//ctx.close();				
	}
	
	public static void main(String args[]) {
		(new CurrencyConverterClient()).test();
	}
}


