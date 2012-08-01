//package com.loiane.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import com.loiane.com.model.City;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration()
								.configure()
								//.addPackage("com.loiane.model") //the fully qualified package name
								.addAnnotatedClass(City.class)
								.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
