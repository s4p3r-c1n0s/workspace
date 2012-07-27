package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiController extends MultiActionController {

	public MultiController(){
		
	}
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("Add");
		
		return null;
		
	}
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("Add");
		
		return null;
		
	}
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("Add");
		
		return null;
		
	}
}
