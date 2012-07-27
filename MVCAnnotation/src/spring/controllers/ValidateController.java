package spring.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.ValidationForm;

@Controller
@RequestMapping("/validateForm.htm")
public class ValidateController {

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showValidatinForm(ModelMap model) {
		ValidationForm validationForm = new ValidationForm();
		model.put("validationForm", validationForm);
		return "validationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processValidatinForm(@Valid ValidationForm validationForm,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "validationform";
		}
		// Add the saved validationForm to the model
		model.put("validationForm", validationForm);
		return "validationsuccess";
	}

}

