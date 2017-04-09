package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.softsquare.application.domain.EmployeeMapping;
import com.softsquare.application.entity.Employee;

public interface EmployeeDao {

	public ArrayList<Employee> getEmployee();
	public  ArrayList<EmployeeMapping> findEmployee(EmployeeMapping employeeMapping);
	public Employee getEmployeeForUpdate(EmployeeMapping mapping);
	public ArrayList<Employee> getProjectManager();
	public ArrayList<Employee> getAllEmployee();
}
