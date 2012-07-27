package com.neelam.training.spring.ioc.example1;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.neelam.training.spring.ioc.common.Flight;


public class FlightServiceClient {

	public void test() {

		
	ClassPathXmlApplicationContext ctx = 
new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example1/applicationContext.xml");
		
		/*Resource res = new FileSystemResource("/iocexamples/src/com/neelam/training/spring/ioc/example1/applicationContext.xml");
		BeanFactory ctx = new XmlBeanFactory(res); 
*/
		Flight fg = (Flight)ctx.getBean("flight");
		System.out.println(fg.getFlightNo());
		
		Flight fg1 = (Flight)ctx.getBean("flight");
		
		
		
		/*FlightServiceDao fs = (FlightServiceDao) ctx.getBean("flightService");
		
	
		
		List flights = fs.getAvailableFlights();
		Iterator itr = flights.iterator();
		while(itr.hasNext()) {
			Flight f = (Flight) itr.next();
			System.out.println(f.getFlightNo()+"\t"+f.getCarrier()+"\t"+f.getFrom()+"\t"+f.getTo());
		}
	*/	
	//	ctx.close();				
	}
	
	public static void main(String args[]) {
		(new FlightServiceClient()).test();
	}
}


