package spring.controllers;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SpringappController {

	@RequestMapping("/hello.htm")
	public void handle(HttpServletRequest req, HttpServletResponse res) throws Exception
	{
		String name =req.getParameter("name");
		// TODO Auto-generated method stub
        //return new ModelAndView("hello","name",name);
		PrintWriter out = res.getWriter();
		out.println("Coming from Sub Controller directly");
		//return null;
	}

}
