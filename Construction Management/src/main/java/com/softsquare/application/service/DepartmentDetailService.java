package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.DepartmentDetailMapping;
import com.softsquare.application.entity.DepartmentDetail;

public interface DepartmentDetailService {

	public ArrayList<DepartmentDetail> getDepartmentDetail();
	public void saveDepartmentDetail(DepartmentDetailMapping mapping) throws Exception ;
	public void removeDepartmentDetail(DepartmentDetailMapping mapping) throws Exception;
	public void updateDepartmentDetail(DepartmentDetailMapping mapping) throws Exception;
	public ArrayList<DepartmentDetailMapping> findDepartmentDetail(DepartmentDetailMapping mapping );
	public ArrayList<DepartmentDetail> AllDepartmentDetail(int departmentId );
	
	
	
}