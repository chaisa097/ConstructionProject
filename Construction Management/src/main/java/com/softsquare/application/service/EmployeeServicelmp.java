package com.softsquare.application.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.EmployeeDao;
import com.softsquare.application.domain.EmployeeMapping;
import com.softsquare.application.entity.Employee;

@Service
public class EmployeeServicelmp implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeedao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public ArrayList<Employee> getEmployee() {
		return employeedao.getEmployee();
	}
	@Override
	public  ArrayList<EmployeeMapping> findEmployee(EmployeeMapping employeeMapping) {
		return employeedao.findEmployee(employeeMapping);
	}
	@Override
	public ArrayList<Employee> getProjectManager() {
		return employeedao.getProjectManager();
	}
	
	
}
