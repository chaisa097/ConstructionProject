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
import com.softsquare.application.entity.Project;

@Service
public class ImportMaterialServiceImp implements ImportMaterialService {
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private WorkingDao workingDao;
	@Autowired
	LoginDao  loginDao;
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public ArrayList<Project> findProjectOfEngineer(){
		  Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
	      Map<String, Object>  project = workingDao.findProejectIdByEmployeeId((int) dataLogin.get("employeeId"));
		return projectDao.findProjectbyProjectId((int) project.get("projectId"));
	}
	
}