package com.neelam.training.spring.ioc.example11;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerValidator implements Validator {
	private final Validator addressValidator;
	public CustomerValidator(Validator addressValidator) {
		if (addressValidator == null) {
			throw new IllegalArgumentException(
					"The supplied [Validator] is required and must not be null.");
		}
		if (!addressValidator.supports(Address.class)) {
			throw new IllegalArgumentException(
					"The supplied [Validator] must support the validation of [Address] instances.");
		}

		this.addressValidator = addressValidator;
	}
	/**
	 * This Validator validates Customer instances, and any subclasses of Customer too
	 */
	public boolean supports(Class clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) {
ValidationUtils.rejectIfEmpty(errors, "name", "name.empty","Name cant be empty");
		
		Customer p = (Customer) target;
		if (p.getAge() < 0) {
			errors.rejectValue("age", "negativevalue", "Age cannot be nagative");
			
		} else if (p.getAge() > 110) {
			//e.rejectValue("age", "too.old");
			errors.rejectValue("age", "too old", "You r very old");
		}
		
		try {
			errors.pushNestedPath("address");
			ValidationUtils.invokeValidator(this.addressValidator, p.getAddress(), errors);
		} finally {
			errors.popNestedPath();
		}
	}
}




