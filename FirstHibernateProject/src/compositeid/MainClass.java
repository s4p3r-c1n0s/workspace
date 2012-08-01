package compositeid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MainClass {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Emp.class);
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		Emp em = new Emp();
		em.setSalary(10000);
		session.save(em);
		session.getTransaction().commit();
		
		
		
	}
}
