package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.Login;
import com.softsquare.application.entity.OrderMaterial;
import com.softsquare.application.entity.Project;
@Repository()
@Component
public class ProjectDaolmp extends AbstractDao<Integer, Project> implements ProjectDao{
	@Autowired
	 private LoginDao  loginDao;
	
	@SuppressWarnings("unchecked")	
	@Override	
	public ArrayList<ProjectMapping> getProject(ProjectMapping projectMapping) {
		 Criteria criteria = getSession().createCriteria(Project.class, "project");
		 criteria.createAlias("project.province", "province");
		 criteria.createAlias("project.employee", "employee");
		 criteria.addOrder(Order.desc("project.projectId"));
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("project.projectId").as("projectId"))
		            .add(Projections.property("project.projectName").as("projectName"))
		            .add(Projections.property("province.provinceName").as("provinceName"))
		            .add(Projections.property("province.provinceId").as("provinceId"))
		            .add(Projections.property("project.description").as("description"))
		            .add(Projections.property("project.address").as("address"))
		            .add(Projections.property("project.startDate").as("startDate"))
		            .add(Projections.property("project.finishDate").as("finishDate"))
		            .add(Projections.property("project.customerName").as("customerName"))
		            .add(Projections.property("project.customerPhone").as("customerPhone"))		           
		            .add(Projections.property("project.budget").as("budget"))
		            .add(Projections.property("project.criticalBudget").as("criticalBudget"))
		            .add(Projections.property("project.totalExpense").as("criBudget"))
		            .add(Projections.property("project.percentStatus").as("percentStatus"))	
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))		       
		            .add(Projections.property("employee.employeeId").as("employeeId"));	
		 criteria.setProjection(projections);			 
		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

		
		ArrayList<ProjectMapping> projectList = (ArrayList<ProjectMapping>) criteria.list();
		return projectList;
		
		 }
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findbugget(int id) {
		 Criteria criteria = getSession().createCriteria(Project.class, "project");
		 ProjectionList projections = Projections.projectionList()				  
				  .add(Projections.property("project.projectId").as("projectId"))
				  .add(Projections.property("project.totalHireEmployee").as("totalHireEmployee"))
				  .add(Projections.property("project.totalUseMaterial").as("totalUseMaterial"))
				  .add(Projections.property("project.totalExpense").as("totalExpense"));

		 criteria.setProjection(projections);	
		 criteria.add(Restrictions.eq("project.projectId",id));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Project> CountProject() {
		 Criteria criteria = getSession().createCriteria(Project.class, "project");
		 ProjectionList projections = Projections.projectionList()				  
				   .add(Projections.count("project.projectId").as("projectId"))
		           .add(Projections.sum("project.budget").as("budget"))
		           .add(Projections.sum("project.totalExpense").as("totalExpense"));
		 criteria.setProjection(projections);		 
		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		ArrayList<Project> projectList = (ArrayList<Project>) criteria.list();
		return projectList;
	}
	
	
	
	@Override	
	public ArrayList<ProjectMapping> getProjectByEmployee(ProjectMapping projectMapping) {
		 Criteria criteria = getSession().createCriteria(Project.class, "project");
		 criteria.createAlias("project.province", "province");
		 criteria.createAlias("project.employee", "employee");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("project.projectId").as("projectId"))
		            .add(Projections.property("project.projectName").as("projectName"))
		            .add(Projections.property("province.provinceName").as("provinceName"))
		            .add(Projections.property("province.provinceId").as("provinceId"))
		            .add(Projections.property("project.description").as("description"))
		            .add(Projections.property("project.address").as("address"))
		            .add(Projections.property("project.startDate").as("startDate"))
		            .add(Projections.property("project.finishDate").as("finishDate"))
		            .add(Projections.property("project.customerName").as("customerName"))
		            .add(Projections.property("project.customerPhone").as("customerPhone"))		           
		            .add(Projections.property("project.budget").as("budget"))
		            .add(Projections.property("project.criticalBudget").as("criticalBudget"))
		            .add(Projections.property("project.totalExpense").as("totalExpense"))
		            .add(Projections.property("project.percentStatus").as("percentStatus"))	
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))		       
		            .add(Projections.property("employee.employeeId").as("employeeId"));	
		 criteria.setProjection(projections);
		 Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
		 if(BeanUtils.isNotEmpty(projectMapping.getProvinceId())){
			 criteria.add(Restrictions.eq("province.provinceId", projectMapping.getProvinceId()));			 
		 }	 
		 criteria.add(Restrictions.eq("employee.employeeId",dataLogin.get("employeeId")));			 
		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

		
		ArrayList<ProjectMapping> projectList = (ArrayList<ProjectMapping>) criteria.list();
		return projectList;
		
		 }
	@Override	
	public ArrayList<Project> getProject() {
		 Criteria criteria = getSession().createCriteria(Project.class, "project");
		 criteria.createAlias("project.province", "province");
		 criteria.createAlias("project.employee", "employee");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("project.projectId").as("projectId"))
		            .add(Projections.property("project.projectName").as("projectName"))
		            .add(Projections.property("province.provinceName").as("provinceName"))
		            .add(Projections.property("province.provinceId").as("provinceId"))
		            .add(Projections.property("project.description").as("description"))
		            .add(Projections.property("project.address").as("address"))
		            .add(Projections.property("project.startDate").as("startDate"))
		            .add(Projections.property("project.finishDate").as("finishDate"))
		            .add(Projections.property("project.customerName").as("customerName"))
		            .add(Projections.property("project.customerPhone").as("customerPhone"))		           
		            .add(Projections.property("project.budget").as("budget"))
		            .add(Projections.property("project.criticalBudget").as("criticalBudget"))
		            .add(Projections.property("project.totalExpense").as("totalExpense"))
		            .add(Projections.property("project.percentStatus").as("percentStatus"))	
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))		       
		            .add(Projections.property("employee.employeeId").as("employeeId"));	
		 criteria.setProjection(projections);		 
		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		ArrayList<Project> projectList = (ArrayList<Project>) criteria.list();
		return projectList;
		
		 }
	
	@Override	
	public ArrayList<Project> findProjectbyProjectId(int projectId) {
		 Criteria criteria = getSession().createCriteria(Project.class, "project");
		 criteria.createAlias("project.province", "province");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("project.projectId").as("projectId"))
		            .add(Projections.property("project.projectName").as("projectName"))		         
		            .add(Projections.property("province.provinceId").as("provinceId"))
		            .add(Projections.property("project.description").as("description"))
		            .add(Projections.property("project.address").as("address"))
		            .add(Projections.property("project.startDate").as("startDate"))
		            .add(Projections.property("project.finishDate").as("finishDate"))
		            .add(Projections.property("project.customerName").as("customerName"))
		            .add(Projections.property("project.customerPhone").as("customerPhone"))		           
		            .add(Projections.property("project.budget").as("budget"))
		            .add(Projections.property("project.criticalBudget").as("criticalBudget"))
		            .add(Projections.property("project.totalExpense").as("totalExpense"))
		            .add(Projections.property("project.totalHireEmployee").as("totalHireEmployee"))
		            .add(Projections.property("project.totalUseMaterial").as("totalUseMaterial"))
		            .add(Projections.property("project.percentStatus").as("percentStatus"));		           	       
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("project.projectId",projectId ));			 
		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		ArrayList<Project> projectList = (ArrayList<Project>) criteria.list();
		return projectList;
		
		 
	}
	
	@SuppressWarnings("unchecked")	
	@Override	
	public ArrayList<ProjectMapping> findProjectId(ProjectMapping projectMapping) {
		 Criteria criteria = getSession().createCriteria(Project.class, "project");
		 criteria.createAlias("project.province", "province");
		 criteria.createAlias("project.employee", "employee");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("project.projectId").as("projectId"))
		            .add(Projections.property("project.projectName").as("projectName"))		         
		            .add(Projections.property("province.provinceId").as("provinceId"))
		            .add(Projections.property("project.description").as("description"))
		            .add(Projections.property("project.address").as("address"))
		            .add(Projections.property("project.startDate").as("startDate"))
		            .add(Projections.property("project.finishDate").as("finishDate"))
		            .add(Projections.property("project.customerName").as("customerName"))
		            .add(Projections.property("project.customerPhone").as("customerPhone"))		           
		            .add(Projections.property("project.budget").as("budget"))
		            .add(Projections.property("project.criticalBudget").as("criticalBudget"))
		            .add(Projections.property("project.totalExpense").as("totalExpense"))
		            .add(Projections.property("project.totalHireEmployee").as("totalHireEmployee"))
		            .add(Projections.property("project.totalUseMaterial").as("totalUseMaterial"))
		            .add(Projections.property("project.percentStatus").as("percentStatus"))			           	       
		            .add(Projections.property("employee.employeeId").as("employeeId"));	
		 criteria.setProjection(projections);
		
		 criteria.add(Restrictions.eq("project.projectId",projectMapping.getProjectId() ));			 
		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		ArrayList<ProjectMapping> projectList = (ArrayList<ProjectMapping>) criteria.list();
		return projectList;
		
		 
	}
		
	
	@Override
	public Project findProejctForUpdate(ProjectMapping projectMapping) {
		Criteria criteria = getSession().createCriteria(Project.class, "project");
		 ProjectionList projections = Projections.projectionList()
				    .add(Projections.property("project.projectId").as("projectId"))
				    .add(Projections.property("project.projectName").as("projectName"))
		            .add(Projections.property("project.description").as("description"))
		            .add(Projections.property("project.address").as("address"))
		            .add(Projections.property("project.startDate").as("startDate"))
		            .add(Projections.property("project.finishDate").as("finishDate"))
		            .add(Projections.property("project.customerName").as("customerName"))
		            .add(Projections.property("project.customerPhone").as("customerPhone"))		           
		            .add(Projections.property("project.budget").as("budget"))
		            .add(Projections.property("project.criticalBudget").as("criticalBudget"))
		            .add(Projections.property("project.totalExpense").as("totalExpense"))
		            .add(Projections.property("project.percentStatus").as("percentStatus"))
		            .add(Projections.property("project.totalHireEmployee").as("totalHireEmployee"))
		            .add(Projections.property("project.totalUseMaterial").as("totalUseMaterial"))		            
		            .add(Projections.property("project.employeeId").as("employeeId"))
		            .add(Projections.property("project.provinceId").as("provinceId"));
		 criteria.setProjection(projections);
		
		 if(BeanUtils.isNotEmpty(projectMapping.getProjectId())){
			 criteria.add(Restrictions.eq("project.projectId", projectMapping.getProjectId()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
		 Project resultList =  (Project) criteria.uniqueResult();
		 
		return resultList;
	}
		
	@Override
	public Project findProejct(int Id) {
		Criteria criteria = getSession().createCriteria(Project.class, "project");
		 ProjectionList projections = Projections.projectionList()
				    .add(Projections.property("project.projectId").as("projectId"))
		            .add(Projections.property("project.description").as("description"))
		            .add(Projections.property("project.address").as("address"))
		            .add(Projections.property("project.startDate").as("startDate"))
		            .add(Projections.property("project.finishDate").as("finishDate"))
		            .add(Projections.property("project.customerName").as("customerName"))
		            .add(Projections.property("project.customerPhone").as("customerPhone"))		           
		            .add(Projections.property("project.budget").as("budget"))
		            .add(Projections.property("project.criticalBudget").as("criticalBudget"))
		            .add(Projections.property("project.totalExpense").as("totalExpense"))
		            .add(Projections.property("project.percentStatus").as("percentStatus"))
		            .add(Projections.property("project.totalHireEmployee").as("totalHireEmployee"))
		            .add(Projections.property("project.totalUseMaterial").as("totalUseMaterial"))		            
		            .add(Projections.property("project.employeeId").as("employeeId"))
		            .add(Projections.property("project.provinceId").as("provinceId"));
		 criteria.setProjection(projections);		
		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
		 Project result =  (Project) criteria.uniqueResult();
		 
		return result;
	}
	
	
	
	@Override
	public void saveProject(Project project) throws Exception {
		save(project);
	}

	@Override
	public void removeProject(Project project) throws Exception {
		delete(project);
	}

	@Override
	public void updateProject(Project project) throws Exception {
		merge(project);
	}
	
	
    
	
	
	
	
//	@Override
//	public ArrayList<Project> getProject() {
//		 Criteria criteria = getSession().createCriteria(Project.class, "project");
//		 criteria.createAlias("project.province", "province");
//		 criteria.createAlias("project.employee", "employee");
//		 ProjectionList projections = Projections.projectionList()
//		            .add(Projections.property("project.projectId").as("projectId"))
//		            .add(Projections.property("project.projectName").as("projectName"))		          
//		            .add(Projections.property("project.description").as("description"))
//		            .add(Projections.property("project.address").as("address"))
//		            .add(Projections.property("project.startDate").as("startDate"))
//		            .add(Projections.property("project.finishDate").as("finishDate"))
//		            .add(Projections.property("project.customerName").as("customerName"))
//		            .add(Projections.property("project.customerPhone").as("customerPhone"))
//		            .add(Projections.property("project.budget").as("budget"))
//		            .add(Projections.property("project.criBudget").as("criBudget"))
//		            .add(Projections.property("project.totalExpense").as("criBudget"))
//		            .add(Projections.property("project.percentStatus").as("percentStatus"))
//		            .add(Projections.property("province.provinceName").as("provinceName"))
//		            .add(Projections.property("employee.employeeId").as("employeeId"));
//		 criteria.add(Restrictions.eq("employee.employeeId", "employeeId"));
//		 criteria.setProjection(projections);
//		 criteria.setResultTransformer(Transformers.aliasToBean(Project.class));
//		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//		 ArrayList<Project> projectList = (ArrayList<Project>) criteria.list();
//		return projectList;
//	}
	
	
	
	}
	
	


