package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.DepartmentDetailDao;
import com.softsquare.application.domain.DepartmentDetailMapping;
import com.softsquare.application.entity.DepartmentDetail;


@Service 
public class DepartmentDetailServiceImp implements DepartmentDetailService {
	
	@Autowired
	 private DepartmentDetailDao depDetailDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	

	@Override
	public ArrayList<DepartmentDetail> getDepartmentDetail() {
		return depDetailDao.getDepartmentDetail();
	}
	@Override
	public ArrayList<DepartmentDetailMapping> findDepartmentDetail(DepartmentDetailMapping mapping ) {
		return depDetailDao.findDepartmentDetail(mapping);
	}
	@Override
	public ArrayList<DepartmentDetail> AllDepartmentDetail(int departmentId ){
		 return depDetailDao.AllDepartmentDetail(departmentId);
	}

	@Override
	public void saveDepartmentDetail(DepartmentDetailMapping mapping)
			throws Exception {
		DepartmentDetail depDetail = new DepartmentDetail();
		System.out.println(mapping.getDepDetailName());
		System.out.println(mapping.getSalary());
		System.out.println(mapping.getDepartmentId());
		depDetail.setDepDetailName(mapping.getDepDetailName());
		depDetail.setSalary(mapping.getSalary());
		depDetail.setDepartmentId(mapping.getDepartmentId());
		depDetailDao.saveDepartmentDetail(depDetail);
		
	}

	@Override
	public void removeDepartmentDetail(DepartmentDetailMapping mapping)
			throws Exception {
		DepartmentDetail depDetail = new DepartmentDetail();
		depDetail.setDepDetailId(mapping.getDepDetailId());
		depDetailDao.removeDepartmentDetail(depDetail);
	}

	@Override
	public void updateDepartmentDetail(DepartmentDetailMapping mapping) throws Exception {
		DepartmentDetail depDetail = depDetailDao.getDepartmentDetailForUpdate(mapping);
		depDetail.setDepDetailName((mapping.getDepDetailName()));
		depDetail.setSalary(mapping.getSalary());
		depDetail.setDepartmentId(mapping.getDepartmentId());
		depDetailDao.updateDepartmentDetail(depDetail);
		
	}


	
	
	
}
