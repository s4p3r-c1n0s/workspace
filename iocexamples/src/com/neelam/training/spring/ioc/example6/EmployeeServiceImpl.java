package com.neelam.training.spring.ioc.example6;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService  {

	private EmployeeDAO employeeDAO;

	public void setEmployeeDao(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public List getAllEmployees() {    
		List emps = employeeDAO.getAllEmployees();        
		return emps;  
	}
}