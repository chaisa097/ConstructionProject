package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.DepartmentMapping;
import com.softsquare.application.entity.Department;


public interface DepartmentDao {
	public ArrayList<Department> getDepartment();
	public Department getDepartmentForUpdate(DepartmentMapping mapping);
	public void saveDepartment(Department department) throws Exception ;
	public void removeDepartment(Department department) throws Exception;
	public void updateDepartment(Department department) throws Exception;
	
	

}