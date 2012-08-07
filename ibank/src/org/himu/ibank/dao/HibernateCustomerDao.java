package org.himu.ibank.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.himu.ibank.domain.Customer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateCustomerDao extends HibernateDaoSupport implements
		CustomerDao {

	@Override
	public Long addNew(Customer c) {
		return (Long) getHibernateTemplate().save(c);
	}

	@Override
	public void delete(Customer c) {
		getHibernateTemplate().delete(c);
	}

	@Override
	public void update(Customer c) {
		getHibernateTemplate().update(c);
	}

	@Override
	public Customer findById(Long id) {
		return (Customer) getHibernateTemplate().get(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Customer findByUserId(String uid) {
		List<Customer> clist =  getHibernateTemplate().find("from Customer c where c.userId = ?", uid);
		if (clist.isEmpty())
			return null;
		else
			return clist.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listAll() {
		return getHibernateTemplate().find("from Customer c");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listAll(int startPage, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.addOrder(Order.asc("id"));
		return getHibernateTemplate().findByCriteria(criteria, startPage, pageSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listByExample(Customer c) {
		return getHibernateTemplate().findByExample(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listByExample(Customer c, int startPage, int pageSize) {
		return getHibernateTemplate().findByExample(c, startPage, startPage);
	}

}
