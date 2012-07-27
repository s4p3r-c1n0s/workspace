package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

public class TestController extends AbstractCommandController{

	public TestController(){
	//	setCommandClass(Test.class);
	}
	
	protected ModelAndView handle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		Test test = (Test)arg2;
		
		return new ModelAndView("TestData","data",test);
		
	}
	

}
