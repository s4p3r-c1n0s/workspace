package org.himu.ibank.service;

import java.util.List;

import org.himu.ibank.dao.CustomerDao;
import org.himu.ibank.domain.Customer;

public class StandardCustomerRegistrationService implements
		CustomerRegistrationService {

	private CustomerDao custDao;
	
	public void setCustDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	@Override
	public Long registerCustomer(Customer c) {
		return custDao.addNew(c);
	}

	@Override
	public void authorizeCustomer(Customer c) {
		if (c.getStatus() == Customer.STATUS_REGISTERED) {
			c.setStatus(Customer.STATUS_ACTIVE);
			custDao.update(c);
			// ... mailer code for notifying customer ...
		}
	}

	/**
	 * Get registered but unauthorized customers using optional paging.
	 * 
	 * @param startPage Starting page number, first page is 0
	 * @param pageSize Size of a single page, <=0 means no paging
	 */
	@Override
	public List<Customer> getUnauthorizedCustomers(int startPage, int pageSize) {
		Customer c = new Customer();
		c.setStatus(Customer.STATUS_REGISTERED);
		return custDao.listByExample(c, startPage, pageSize);
	}

	/**
	 * Get registered and authorized customers using optional paging.
	 * 
	 * @param startPage Starting page number, first page is 0
	 * @param pageSize Size of a single page, <=0 means no paging
	 */
	@Override
	public List<Customer> getCustomers(int startPage, int pageSize) {
		Customer c = new Customer();
		c.setStatus(Customer.STATUS_ACTIVE);
		return custDao.listByExample(c, startPage, pageSize);
	}

	@Override
	public List<Customer> getAllCustomers(int startPage, int pageSize) {
		return custDao.listAll(startPage, pageSize);
	}
}
