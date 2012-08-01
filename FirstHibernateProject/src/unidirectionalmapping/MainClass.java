package unidirectionalmapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
	 static SessionFactory factory;
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.addAnnotatedClass(Employee.class);
		/*cfg.addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Project.class);
		cfg.addAnnotatedClass(Department.class);
		 */
		
		cfg.addAnnotatedClass(EmployeeDetail.class);
		 cfg.configure();

		  factory = cfg.buildSessionFactory();

		 Session session = factory.openSession();
		 session.beginTransaction();
		 Employee emp = new Employee();
		 emp.setAge(30);
		 emp.setName("Neeraja");
		 EmployeeDetail ed = new EmployeeDetail();
		 ed.setEmployeeId(1);
		 ed.setCellphone("456");
		 ed.setNoOfDependents(12);
		 emp.setDetails(ed);
		 
		 session.save(emp);
		 session.getTransaction().commit();
		 getEmployee();
	}

	static void getEmployee(){
		Session session = factory.openSession();
		 session.beginTransaction();
		 Employee emp= (Employee)session.get(Employee.class, 1);
		 System.out.println(emp.getDetails().getCellphone());
		 session.getTransaction().commit();
	}

}
