package controllers;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidatorTest implements Validator{

	@Override
	public boolean supports(Class arg0) {
		return arg0.equals(Test.class);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Test test = (Test)arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace
		(arg1, "name", "name.required","name must not be empty");
		ValidationUtils.rejectIfEmpty
		(arg1, "id", "id.required","Id must not be empty");
		
		if(test.getName().length()<=5){
			arg1.rejectValue
			("name", "name.length", "Name shd not be less then 5 chrs");
		}
	}

}







