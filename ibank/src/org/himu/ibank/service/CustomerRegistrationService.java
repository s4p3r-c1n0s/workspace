package org.himu.ibank.service;

import java.util.List;

import org.himu.ibank.domain.Customer;

public interface CustomerRegistrationService {

	Long registerCustomer(Customer c);
	void authorizeCustomer(Customer c);
	List<Customer> getUnauthorizedCustomers(int startPage, int pageSize);
	List<Customer> getCustomers(int startPage, int pageSize);
	List<Customer> getAllCustomers(int startPage, int pageSize);
}
