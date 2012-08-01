//package com.loiane.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.loiane.com.model.City;
//import com.loiane.util.HibernateUtil;

public class CityDAO {

	public Long saveCity(String cityName, String stateName)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long cityId = 1L;
		try {
			transaction = session.beginTransaction();
			City city = new City();
			city.setName(cityName);
			city.setState(stateName);
			session.save(city);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cityId;
	}

	@SuppressWarnings("unchecked")
	public void listCities()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<City> cities = session.createQuery("from City").list();

			for (City city : cities){
				System.out.println(city.getName());
				System.out.println(city.getState());
			}

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateCity(Long cityId, String cityName,String stateName)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			City city = (City) session.get(City.class, cityId);
			city.setName(cityName);
			city.setState(stateName);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteCity(Long cityId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			City city = (City) session.get(City.class, cityId);
			session.delete(city);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
