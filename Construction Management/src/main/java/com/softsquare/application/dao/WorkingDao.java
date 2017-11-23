package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.domain.WorkingMapping;
import com.softsquare.application.entity.Project;
import com.softsquare.application.entity.Working;

public interface WorkingDao {

	public ArrayList<WorkingMapping> findWorkbyProjectId(WorkingMapping workingMapping);
	
	public void saveWorking(Working working) throws Exception;
	public void removeWorking(Working working) throws Exception ;
	public ArrayList<Working> findProejectByEmployeeId(int employeeId); 
	public ArrayList<Working> findWorkbyEmployeeId(int workerId);
	public ArrayList<Working> findWorker();
	
}
