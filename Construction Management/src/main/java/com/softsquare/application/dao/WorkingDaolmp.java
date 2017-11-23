package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.ManageRoleMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.domain.WorkingMapping;
import com.softsquare.application.entity.Login;
import com.softsquare.application.entity.Project;
import com.softsquare.application.entity.Role;
import com.softsquare.application.entity.Working;
@Repository()
@Component
public class WorkingDaolmp extends AbstractDao<Integer, Working> implements WorkingDao {

		
	@Override	
	public ArrayList<WorkingMapping> findWorkbyProjectId(WorkingMapping workingMapping) {
		 Criteria criteria = getSession().createCriteria(Working.class, "working");
		 criteria.createAlias("working.project", "project");
		 criteria.createAlias("working.employee", "employee");
		 criteria.createAlias("employee.departmentDetail","departmentDetail");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("working.workingId").as("workingId"))
		            .add(Projections.property("working.employeeId").as("employeeId"))
		            .add(Projections.property("working.amountOfMonth").as("amountOfMonth"))  
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.employeeCode").as("employeeCode"))        
		            .add(Projections.property("departmentDetail.Salary").as("Salary"))
		            .add(Projections.property("departmentDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("project.totalHireEmployee").as("totalHireEmployee"))
		            .add(Projections.property("project.projectId").as("projectId"));		           
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("project.projectId",workingMapping.getProjectId()));			 
		 criteria.setResultTransformer(Transformers.aliasToBean(Working.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		ArrayList<WorkingMapping> workingList = (ArrayList<WorkingMapping>) criteria.list();
		return workingList;
		
	}
	@Override	
	public ArrayList<Working> findWorker() {
		 Criteria criteria = getSession().createCriteria(Working.class, "working");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("working.workingId").as("workingId"))
		            .add(Projections.property("working.employeeId").as("employeeId")); 	           
		 criteria.setProjection(projections);		 
		 criteria.setResultTransformer(Transformers.aliasToBean(Working.class));
		ArrayList<Working> workingList = (ArrayList<Working>) criteria.list();
		return workingList;
		
	}
	
	@Override	
	public ArrayList<Working> findWorkbyEmployeeId(int workerId ) {
		 Criteria criteria = getSession().createCriteria(Working.class, "working");
		 criteria.createAlias("working.project", "project");
		 criteria.createAlias("working.employee", "employee");
		 criteria.createAlias("employee.departmentDetail","departmentDetail");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("working.workingId").as("workingId"))
		            .add(Projections.property("working.employeeId").as("employeeId"))  
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.employeeCode").as("employeeCode"));              		           
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("working.employeeId",workerId ));			 
		 criteria.setResultTransformer(Transformers.aliasToBean(Working.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		ArrayList<Working> workingList = (ArrayList<Working>) criteria.list();
		return workingList;
	}
	
	
	@Override
	public void saveWorking(Working working) throws Exception {
		save(working);
	}
	
	@Override
	public void removeWorking(Working working) throws Exception {
		delete(working);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findProejectIdByEmployeeId(int employeeId) {
		 Criteria criteria = getSession().createCriteria(Working.class, "working");
		 criteria.createAlias("working.project", "project");
		 criteria.createAlias("working.employee", "employee");
		 criteria.createAlias("employee.departmentDetail", "departmentDetail");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("working.workingId").as("workingId"))
		            .add(Projections.property("working.employeeId").as("employeeId"))
		            .add(Projections.property("project.projectId").as("projectId"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(employeeId)){
			 criteria.add(Restrictions.eq("working.employeeId", employeeId));			 
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> loginList = (Map<String, Object>) criteria.uniqueResult();
		return loginList;
	}
	
	
	
	
}
