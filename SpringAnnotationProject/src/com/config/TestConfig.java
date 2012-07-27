package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import com.model.Address;
import com.model.Employee;
import com.model.HelloWorld;

@Configuration

//@Component
public class TestConfig {

   

  
   
   
   @Bean
   public Address getAddress(){
	   return new Address("Noida","India");
   }
}



