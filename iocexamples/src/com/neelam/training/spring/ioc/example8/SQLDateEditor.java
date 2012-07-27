package com.neelam.training.spring.ioc.example8;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLDateEditor extends PropertyEditorSupport {

	public void setAsText(String text) {
		if(text.equalsIgnoreCase("getdate")) {
			Date date = new Date(System.currentTimeMillis());
			setValue(date);
		}
		else {
			try{
			DateFormat d = new SimpleDateFormat("MM-dd-yyyy");
			Date d1 = d.parse(text);
			setValue(d1);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
}
