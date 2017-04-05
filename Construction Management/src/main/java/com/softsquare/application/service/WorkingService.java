package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.domain.WorkingMapping;

public interface WorkingService {

	  public  ArrayList<WorkingMapping> findWorker(WorkingMapping workingMapping);
	  public void save(WorkingMapping mapping) throws Exception;
	  public void removeWorker(WorkingMapping mapping) throws Exception;
	  public void updatetotalHireEmployee(ProjectMapping mapping) throws Exception;
	
}

