package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.Login;
import com.softsquare.application.entity.Project;


public interface ProjectDao {


	public void saveProject(Project project) throws Exception;
	public void removeProject(Project project) throws Exception;
	public void updateProject(Project project) throws Exception;
	public Project findProejctForUpdate(ProjectMapping projectMapping);
	public ArrayList<ProjectMapping> findProjectId(ProjectMapping projectMapping);
	public ArrayList<ProjectMapping> getProject(ProjectMapping projectMapping);
	public ArrayList<ProjectMapping> getProjectByEmployee(ProjectMapping projectMapping);
	public Project findProejct(int Id) ;
	public Map<String, Object> findbugget(int id);
	public ArrayList<Project> findProjectbyProjectId(int projectId) ;
	public ArrayList<Project> getProject() ;
	public ArrayList<Project> CountProject(); 
	public ArrayList<Project> CountProjectPM();
	public ArrayList<Project> getProjectPMId();
	public ArrayList<Project> CountProjectComplete();
}
