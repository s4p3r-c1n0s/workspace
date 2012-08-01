package inheritance;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;





public class MainClass {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Professor.class);
		cfg.addAnnotatedClass(RegularProfessor.class);
		cfg.addAnnotatedClass(ContractProfessor.class);
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		
		
	}
}
