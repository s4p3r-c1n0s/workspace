package singletable;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import singletable.Employee;



public class MainClass {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Employee.class);
		
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Employee emp = new Employee();
		
		emp.setEmpName("Neelam");
		emp.setSalary(40000);
		Calendar cl = Calendar.getInstance();
		cl.set(2010, 8, 1);
		Date d = cl.getTime();
		emp.setDateOfJoining(d);
		emp.setEmpStatus(EmployeeStatus.FULL_TIME);
		session.save(emp);
		session.getTransaction().commit();
		
		session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, 1);
		
		System.out.println(e);
		session.getTransaction().commit();
		
		
	
		
		
	}
}
