package spring.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import spring.model.User;


@Controller
@RequestMapping("/loginForm")
@SessionAttributes("formdata")
public class FormController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(	ModelMap model) {
		User user = new User();

		model.put("formdata", user );

		return "LoginForm";
	}


	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("formdata") User user, SessionStatus status) {
		System.out.println(user.getName());
		
		//return "LoginSuccess";
		status.setComplete();
		return "redirect:LoginSuccess.jsp";
	}
	
	@ModelAttribute("webFrameworkList")
	public List<String> populateWebFrameworkList() {
 
		//Data referencing for web framework checkboxes
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");
 
		return webFrameworkList;
	}

}




