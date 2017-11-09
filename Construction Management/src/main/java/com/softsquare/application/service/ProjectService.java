package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.Project;
import com.softsquare.application.entity.Province;

public interface ProjectService {
	

	public  ArrayList<ProjectMapping> findProjectbyEmployee(ProjectMapping projectMapping);
	public void saveProject(ProjectMapping project) throws Exception ;
	public void removeProject(ProjectMapping project) throws Exception ;
	public void updateProject(ProjectMapping project) throws Exception;
	 public  ArrayList<ProjectMapping> findProject(ProjectMapping projectMapping);
	 public  ArrayList<ProjectMapping> getAllProject(ProjectMapping projectMapping);
		public ArrayList<Project> getProject();
		public ArrayList<Project> countProject();
		public ArrayList<Project> countProjectPM();
		public void updateProjectProgress(ProjectMapping project) throws Exception;
			
}
