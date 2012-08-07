package org.himu.ibank.controller;

import java.util.HashMap;
import java.util.Map;

import org.himu.ibank.domain.Customer;
import org.himu.ibank.service.CustomerRegistrationService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class NewCustomerController extends SimpleFormController {

	private CustomerRegistrationService custRegService;

	public void setCustRegService(CustomerRegistrationService custRegService) {
		this.custRegService = custRegService;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		Customer c = (Customer) command;
		custRegService.registerCustomer(c);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put(getCommandName(), c);
		return new ModelAndView(getSuccessView());
	}
	
}
