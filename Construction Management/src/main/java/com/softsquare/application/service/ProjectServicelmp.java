package com.softsquare.application.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.ProjectDao;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.Project;


@Service
public class ProjectServicelmp implements ProjectService {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProjectDao projectListDao;

	
	@Override
	public  ArrayList<ProjectMapping> findProjectbyEmployee(ProjectMapping projectMapping) {
		
	
		return projectListDao.getProjectByEmployee(projectMapping);
	}
	
	@Override
	public  ArrayList<ProjectMapping> getAllProject(ProjectMapping projectMapping) {
		return projectListDao.getProject(projectMapping);
	}
	@Override
	  public  ArrayList<ProjectMapping> findProject(ProjectMapping projectMapping) {
		
	
		return projectListDao.findProjectId(projectMapping);
	}
	
	
	@Override
	public void saveProject(ProjectMapping project) throws Exception {
		Project pro = new Project();
		pro.setProjectName(project.getProjectName());
		pro.setDescription(project.getDescription());
		pro.setAddress(project.getAddress());
	    pro.setBudget(project.getBudget());
	    pro.setCriticalBudget(project.getCriticalBudget());
	    pro.setProvinceId(project.getProvinceId());
	    pro.setEmployeeId(project.getEmployeeId());	  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date convertedStartDate = sdf.parse(project.getStartDate());
	    Date convertedFinishDate = sdf.parse(project.getFinishDate());	    	    
        pro.setStartDate(convertedStartDate);
	    pro.setFinishDate(convertedFinishDate);
	    pro.setPercentStatus(project.getPercentStatus());
	    pro.setCustomerName(project.getCustomerName());
	    pro.setCustomerPhone(project.getCustomerPhone());
	    pro.setTotalExpense(project.getTotalExpense());
	    pro.setTotalHireEmployee(project.getTotalHireEmployee());
	    pro.setTotalUseMaterial(project.getTotalUseMaterial());
	    projectListDao.saveProject(pro);
	}

	@Override
	public void removeProject(ProjectMapping project) throws Exception {
		Project pro = new Project();
		pro.setProjectId(project.getProjectId());
		projectListDao.removeProject(pro);
	}

	@Override
	public void updateProject(ProjectMapping project) throws Exception {
		Project pro =  projectListDao.findProejctForUpdate(project);
		pro.setProjectName(project.getProjectName());
		pro.setDescription(project.getDescription());
		pro.setAddress(project.getAddress());
	    pro.setBudget(project.getBudget());
	    pro.setCriticalBudget(project.getCriticalBudget());
	    pro.setProvinceId(project.getProvinceId());
	    pro.setEmployeeId(project.getEmployeeId());	  	    	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date convertedStartDate = sdf.parse(project.getStartDate());
	    Date convertedFinishDate = sdf.parse(project.getFinishDate());
        pro.setStartDate(convertedStartDate);
	    pro.setFinishDate(convertedFinishDate);
	    pro.setPercentStatus(project.getPercentStatus());
	    pro.setCustomerName(project.getCustomerName());
	    pro.setCustomerPhone(project.getCustomerPhone());
	    pro.setTotalExpense(project.getTotalExpense());
	    pro.setTotalHireEmployee(project.getTotalHireEmployee());
	    pro.setTotalUseMaterial(project.getTotalUseMaterial());
	    projectListDao.updateProject(pro);
	}

	
	
	}
	

