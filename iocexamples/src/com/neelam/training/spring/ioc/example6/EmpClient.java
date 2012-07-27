package com.neelam.training.spring.ioc.example6;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpClient {

	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/neelam/training/spring/ioc/example6/applicationContext.xml");
		EmployeeService employeeService = (EmployeeService)ctx.getBean("employeeService");
		Iterator empIter = employeeService.getAllEmployees().iterator();
		while(empIter.hasNext()) {
			Emp emp = (Emp)empIter.next();
			System.out.println(emp.getEmpno()+" ( " + emp.getName()+")");
		}
		    
	}		

	public static void main(String[] args)  throws Exception {
		(new EmpClient()).test();
	}
}