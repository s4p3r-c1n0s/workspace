package com.neelam.training.spring.ioc.example11;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class AddressValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return Address.class.equals(clazz);
		
	}

	@Override
	public void validate(Object obj, Errors e) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmpty(e, "state", "state.empty","State should be mentioned");
		
	}

 
	
}
