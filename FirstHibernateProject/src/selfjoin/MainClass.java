package selfjoin;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;





public class MainClass {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(EmployeeManyToMany.class);
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		
		
	}
}
