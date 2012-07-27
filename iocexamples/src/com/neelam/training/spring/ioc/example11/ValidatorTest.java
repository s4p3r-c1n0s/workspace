package com.neelam.training.spring.ioc.example11;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class ValidatorTest implements Validator{

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		System.out.println("Supports");
		return false;
		
	}

	@Override
	public void validate(Object obj, Errors e) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmpty(e, "name", "name.empty","Name cant be empty");
		
		Customer p = (Customer) obj;
		if (p.getAge() < 0) {
			e.rejectValue("age", "negativevalue", "Age cannot be nagative");
			
		} else if (p.getAge() > 110) {
			//e.rejectValue("age", "too.old");
			e.rejectValue("age", "too old", "You r very old");
		}
		
	}

 
	
}
