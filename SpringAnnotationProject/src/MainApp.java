import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.HelloWorldConfig;
import com.model.Employee;
import com.model.HelloWorld;


public class MainApp {
	
	
	public static void main(String[] args) {
		 ApplicationContext ctx = 
			      new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		     
	   
	      HelloWorld helloWorld = ctx.getBean(HelloWorld.class);

	      //helloWorld.setMessage("Hello World!");
	      helloWorld.getMessage();
	      
	      Employee emp = ctx.getBean(Employee.class);
	      System.out.println(emp.getName());
	      
	      System.out.println(emp.getAddress().getState());
	   }
}
