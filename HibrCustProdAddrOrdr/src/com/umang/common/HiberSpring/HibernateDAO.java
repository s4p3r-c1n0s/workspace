package com.umang.common.HiberSpring;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDAO {

	public Long saveAddress(int houseNumber,String cityName, String stateName, int zipNumber)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long addressId = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address();
			address.setCity(cityName);
			address.sethNo(houseNumber);
			address.setState(stateName);
			address.setZip(zipNumber);
			addressId = (Long) session.save(address);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return addressId;
	}
}