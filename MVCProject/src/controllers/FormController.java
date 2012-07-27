package controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


public class FormController extends SimpleFormController {

	public ModelAndView onSubmit(Object cmd) throws Exception{
		
		Test test = (Test)cmd;
		return new ModelAndView(getSuccessView(),"data",test);
	}
}
