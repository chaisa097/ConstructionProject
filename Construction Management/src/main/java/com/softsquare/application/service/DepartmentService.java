package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.DepartmentMapping;
import com.softsquare.application.entity.Department;
import com.softsquare.application.entity.Province;

public interface DepartmentService {

	public ArrayList<Department> getDepartment();
	public void saveDepartment(DepartmentMapping mapping) throws Exception ;
	public void removeDepartment(DepartmentMapping mapping) throws Exception;
	public void updateDepartment(DepartmentMapping mapping) throws Exception;
	
	
	
}
