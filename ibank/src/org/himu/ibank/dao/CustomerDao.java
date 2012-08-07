package org.himu.ibank.dao;

import java.util.List;

import org.himu.ibank.domain.Customer;

public interface CustomerDao {

	Long addNew(Customer c);
	void delete(Customer c);
	void update(Customer c);
	Customer findById(Long id);
	Customer findByUserId(String uid);
	List<Customer> listAll();
	List<Customer> listAll(int startPage, int pageSize);
	List<Customer> listByExample(Customer c);
	List<Customer> listByExample(Customer c, int startPage, int pageSize);
}
