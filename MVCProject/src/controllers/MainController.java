
package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("Hello");
		String greeting  = "Welcome to First Page";
		//arg0.setAttribute("greeting",greeting);
		ModelAndView mav = new ModelAndView("Welcome");
		mav.addObject("greeting",greeting);
		return mav;
		
	}

}






