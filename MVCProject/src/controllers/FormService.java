package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;

public class FormService{

	
	public void insertData( WebApplicationContext wac , FormData form){
	
SessionFactory sessionFac = (SessionFactory)wac.getBean("exampleSessionFactory");
	
	Session session = sessionFac.openSession();
	session.beginTransaction();
	System.out.println(sessionFac);
	System.out.println(form.getExp());
	session.save(form);
	session.getTransaction().commit();
	
	}
}
