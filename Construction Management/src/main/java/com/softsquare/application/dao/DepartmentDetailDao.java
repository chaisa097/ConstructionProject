package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.DepartmentDetailMapping;
import com.softsquare.application.entity.DepartmentDetail;

public interface DepartmentDetailDao {
	public ArrayList<DepartmentDetail> getDepartmentDetail();
	public DepartmentDetail getDepartmentDetailForUpdate(DepartmentDetailMapping mapping);
	public void saveDepartmentDetail(DepartmentDetail dep) throws Exception ;
	public void removeDepartmentDetail(DepartmentDetail dep) throws Exception;
	public void updateDepartmentDetail(DepartmentDetail dep) throws Exception;
}