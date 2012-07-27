package com.neelam.training.spring.ioc.example10;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ContextAwareDemo  {

   

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                "src/com/neelam/training/spring/ioc/example10/aware.xml");
        
      displayContext disp = (displayContext)ctx.getBean("displayContext");
      disp.displayAppContext();
        
    }

    
  
        
     
}




