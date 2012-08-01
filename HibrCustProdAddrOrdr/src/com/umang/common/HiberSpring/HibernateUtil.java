package com.umang.common.HiberSpring;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration()
								.configure()
								.addAnnotatedClass(Address.class)
								.addAnnotatedClass(Customer.class)
								.addAnnotatedClass(UserId.class)
								.addAnnotatedClass(User.class)
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
