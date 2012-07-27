package controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.BindException;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

public class MultiPageController extends AbstractWizardFormController  {




	public MultiPageController(){
		setCommandClass(FormData.class);
		
		
	}
	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		// TODO Auto-generated method stub
		
		return new ModelAndView("Welcome");
	}

	@Override
	protected ModelAndView processFinish(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			 {
		FormData data = (FormData)arg2;
		WebApplicationContext wbctx =  getWebApplicationContext();
		//System.out.println(data.getAge() + data.getId());
	
		FormService service= new FormService();
		service.insertData(wbctx, data);
	
	
		return new ModelAndView("Success","data",data);
	}
	

}
