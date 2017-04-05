package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.log.SysoCounter;
import com.softsquare.application.dao.ProjectDao;
import com.softsquare.application.dao.WorkingDao;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.domain.WorkingMapping;
import com.softsquare.application.entity.Project;
import com.softsquare.application.entity.Province;
import com.softsquare.application.entity.Working;


@Service
public class WorkingServicelmp implements WorkingService {
	
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private WorkingDao workingDao;
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	  public  ArrayList<WorkingMapping> findWorker(WorkingMapping workingMapping) {			
		return workingDao.findWorkbyProjectId(workingMapping);
	}
 
	@Override
	public void save(WorkingMapping mapping) throws Exception {
		Working work = new  Working();
		work.setEmployeeId(mapping.getEmployeeId());
		work.setProjectId(mapping.getProjectId());
		work.setAmountOfMonth(mapping.getAmountOfMonth());	
		workingDao.saveWorking(work);
	
	}
	
	@Override
	public void removeWorker(WorkingMapping mapping) throws Exception {
		Working work = new  Working();
		work.setWorkingId(mapping.getWorkingId());
	    workingDao.removeWorking(work);
	}
	@Override
	public void updatetotalHireEmployee(ProjectMapping mapping) throws Exception {
		Project  pro = projectDao.findProejctForUpdate(mapping);
	    pro.setTotalHireEmployee(mapping.getTotalHireEmployee());   
		projectDao.updateProject(pro);
	}
	
	
}
