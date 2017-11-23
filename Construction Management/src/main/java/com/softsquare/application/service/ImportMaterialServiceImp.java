package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.dao.LoginDao;
import com.softsquare.application.dao.ProjectDao;
import com.softsquare.application.dao.WorkingDao;
import com.softsquare.application.entity.Working;

@Service
public class ImportMaterialServiceImp implements ImportMaterialService {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WorkingDao workingDao;
	@Autowired
	LoginDao  loginDao;
	@Autowired
	private ProjectDao projectDao;
	
	// list Only project of engineer can view 
	@Override
	public ArrayList<Working> findProjectOfEngineer(){
		
         // find Login Id of engineer by username
		  Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
		 // find  projectId of employee in working entity
		return  workingDao.findProejectByEmployeeId((int) dataLogin.get("employeeId"));
	}
	
}
