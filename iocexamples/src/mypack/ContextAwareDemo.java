package mypack;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContextAwareDemo  {

   

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "src/mypack/aware.xml");
        
      displayContext disp = (displayContext)ctx.getBean("displayContext");
      disp.displayAppContext();
        
    }

    
  
        
     
}




