package com.softsquare.application.service;

import java.util.ArrayList;
import com.softsquare.application.domain.EmployeeMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.Employee;



public interface EmployeeService {
	
	public ArrayList<Employee> getEmployee();
	public  ArrayList<EmployeeMapping> findEmployee(EmployeeMapping employeeMapping);
	public ArrayList<Employee> getProjectManager();
	public ArrayList<Employee> getAllEmployee();
	public void saveEmployee(EmployeeMapping mapping) throws Exception;
	public  ArrayList<Employee> CountEmployee();
	public void updateEmployee(EmployeeMapping mapping) throws Exception ;
	public  ArrayList<EmployeeMapping> findEmployeeByID(EmployeeMapping employeeMapping) ;
	public ArrayList<Employee> getEmployeeForUserLogin();
	public void removeEmployee(EmployeeMapping employee) throws Exception;
	public  ArrayList<EmployeeMapping> findEmployeeByIdForView(EmployeeMapping employeeMapping);
}
