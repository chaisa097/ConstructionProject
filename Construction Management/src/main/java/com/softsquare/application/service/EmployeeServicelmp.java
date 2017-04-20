package com.softsquare.application.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.DateUtils;
import com.softsquare.application.dao.EmployeeDao;
import com.softsquare.application.domain.DepartmentMapping;
import com.softsquare.application.domain.EmployeeMapping;
import com.softsquare.application.entity.Department;
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
	public ArrayList<Employee> getAllEmployee() {
		return employeedao.getAllEmployee();
	}
	@Override
	public  ArrayList<EmployeeMapping> findEmployee(EmployeeMapping employeeMapping) {
		return employeedao.findEmployee(employeeMapping);
	}
	@Override
	public ArrayList<Employee> getProjectManager() {
		return employeedao.getProjectManager();
	}
	@Override
	public void saveEmployee(EmployeeMapping mapping) throws Exception {
		Employee  emp  = new Employee();
		emp.setEmpFirstName(mapping.getEmpFirstName());
		emp.setEmpLastName(mapping.getEmpLastName());
		emp.setGender(mapping.getGender());
		 Map<String, Object> No = employeedao.findNoMax();
		 if(BeanUtils.isNull(No.get("employeeCode"))){		 
			 emp.setEmployeeCode("000001"); 	
		    }
		   else {
			 Integer codeNo = Integer.parseInt((String) No.get("employeeCode"))+1;
			 String codeNoString = String.format("%06d",codeNo);		   
			 emp.setEmployeeCode(codeNoString);
			   
		   }
		emp.setCitizenId(mapping.getCitizenId());
	
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
	    Date convertedbirthday = sdf.parse(mapping.getBirthDay());
		emp.setBirthDay(convertedbirthday);
		emp.setDepartmentDetailId(mapping.getDepartmentDetailId());
		emp.setProvinceId(mapping.getProvinceId());
		emp.setSubDistrict(mapping.getSubDistrict());
		emp.setDistrict(mapping.getDistrict());
		Date  createDate = new Date();
		emp.setStartHireDate(createDate);
		employeedao.saveEmployee(emp);
		
		
		
	}
	
}
