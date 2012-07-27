package com.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.model.Address;
import com.model.Employee;
import com.model.HelloWorld;

//@Configuration

@Component
@Import(value = { TestConfig.class })
public class HelloWorldConfig {

	@Bean
	public DataSource getDS(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("");
	//ds.se
		return ds;
		
	}
	
   @Bean
   @Scope("prototype")
   public HelloWorld world(){
	   HelloWorld hw = new HelloWorld();
	//   hw.setDataSource(getDS());
	   hw.setMessage("Hello");
      return hw;
   }

   @Bean(name="emp")
     public Employee getEmployee(){
	   return new Employee("Neelam",44,44444, getAddress1());
   }
   
   @Bean(name="add")
   public Address getAddress(){
	   return new Address("Noida","India");
   }
   
   @Bean(name="add1")
   public Address getAddress1(){
	   return new Address("Delhi","India");
   }
}