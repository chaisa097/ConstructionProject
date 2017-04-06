package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.DepartmentDao;
import com.softsquare.application.dao.ProvinceDao;
import com.softsquare.application.domain.DepartmentMapping;
import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.entity.Department;
import com.softsquare.application.entity.Province;

@Service 
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	 private DepartmentDao depDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Override
	public ArrayList<Department> getDepartment() {
		return depDao.getDepartment();
	}
	
	@Override
	public void saveDepartment(DepartmentMapping mapping) throws Exception {
		Department dep = new Department();
		System.out.println(mapping.getDepartmentCode());
		System.out.println(mapping.getDepartmentName());
		dep.setDepartmentCode(mapping.getDepartmentCode());
		dep.setDepartmentName(mapping.getDepartmentName());
		depDao.saveDepartment(dep);
	}
	
	@Override
	public void removeDepartment(DepartmentMapping mapping) throws Exception {
		Department dep = new Department();
		dep.setDepartmentId(mapping.getDepartmentId());
		depDao.removeDepartment(dep);
	}
	
	@Override
	public void updateDepartment(DepartmentMapping mapping) throws Exception {
		Department dep = depDao.getDepartmentForUpdate(mapping);
		dep.setDepartmentCode(mapping.getDepartmentCode());
		dep.setDepartmentName(mapping.getDepartmentName());
		depDao.updateDepartment(dep);
	}
	
	
	
}
