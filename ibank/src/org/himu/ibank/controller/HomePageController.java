package org.himu.ibank.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HomePageController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// time at the server
		Date today = Calendar.getInstance().getTime();
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("today", today);
		
		return mv;
	}
}
