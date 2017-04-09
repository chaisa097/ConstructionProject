package com.softsquare.application.service;

import java.util.ArrayList;
import com.softsquare.application.domain.EmployeeMapping;
import com.softsquare.application.entity.Employee;



public interface EmployeeService {
	
	public ArrayList<Employee> getEmployee();
	public  ArrayList<EmployeeMapping> findEmployee(EmployeeMapping employeeMapping);
	public ArrayList<Employee> getProjectManager();
	public ArrayList<Employee> getAllEmployee();
	
}
