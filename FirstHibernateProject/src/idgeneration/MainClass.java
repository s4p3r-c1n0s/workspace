package idgeneration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;






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
		emp.setSalary(300000);
		session.save(emp);
		Employee emp1 = new Employee();
		emp1.setEmpName("Neelam");
		emp1.setSalary(500000);
		session.save(emp1);
		
		session.getTransaction().commit();
		
		
	}
}
