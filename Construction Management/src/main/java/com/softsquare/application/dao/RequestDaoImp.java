package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.domain.RequestMaterialMapping;
import com.softsquare.application.entity.Login;
import com.softsquare.application.entity.Project;
import com.softsquare.application.entity.RequestMaterial;


@Repository()
@Component
public class RequestDaoImp extends AbstractDao<Integer,RequestMaterial> implements RequestMaterialDao {
	
	@Autowired
	 private LoginDao  loginDao;
	
	
	@Override
	public void RequestSave(RequestMaterial request) throws Exception {
		save(request);
	}
	
	@Override
	public void updateRequest(RequestMaterial request) throws Exception {
		merge(request);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findRequestId(int requestId) {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
		         .add(Projections.property("request.projectId").as("projectId"))
		         .add(Projections.property("request.employeeId").as("employeeId")); 
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(requestId)){
			 criteria.add(Restrictions.eq("request.requestMaterialId",requestId));			 
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> OrderList = (Map<String, Object>) criteria.uniqueResult();
		return OrderList;
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findRequestNoMax() {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 ProjectionList projections = Projections.projectionList()				  
		            .add(Projections.max("request.requestMaterialNo").as("requestMaterialNo"));		         		 
		 criteria.setProjection(projections);		
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
	
	@Override
	public ArrayList<RequestMaterial> getRequestMaterial() {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
		            .add(Projections.property("request.employeeId").as("employeeId"))
		            .add(Projections.property("request.status").as("status"))
		            .add(Projections.property("request.requestMaterialNo").as("requestMaterialNo"))
		            .add(Projections.property("request.requestDate").as("requestDate"));

		 criteria.setProjection(projections);
		 criteria.add(Restrictions.or(Restrictions.eq("request.status","Open"),Restrictions.eq("request.status","Reject")));
		 Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());		 
		 criteria.add(Restrictions.and(Restrictions.eq("request.employeeId",dataLogin.get("employeeId"))));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterial> RequestMaterialList = (ArrayList<RequestMaterial>) criteria.list();
		return RequestMaterialList;
	}
	

	
	
	
	

	@Override
	public ArrayList<RequestMaterial> listWaitconfirmRequestMaterial() {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
		            .add(Projections.property("request.employeeId").as("employeeId"))
		            .add(Projections.property("request.status").as("status"))
		            .add(Projections.property("request.requestMaterialNo").as("requestMaterialNo"))
		            .add(Projections.property("request.requestDate").as("requestDate"));

		 criteria.setProjection(projections);
		 criteria.add(Restrictions.or(Restrictions.eq("request.status","Waiting Confirm"),Restrictions.eq("request.status","Reject"),Restrictions.eq("request.status","Waiting Material")));
		 Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());		 
		 criteria.add(Restrictions.and(Restrictions.eq("request.employeeId",dataLogin.get("employeeId"))));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterial> RequestMaterialList = (ArrayList<RequestMaterial>) criteria.list();
		return RequestMaterialList;
	}
	
	
	
	
	
	@Override
	public ArrayList<RequestMaterialMapping> listWaitconfirmRequestMaterialPM(RequestMaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 criteria.createAlias("request.employee", "employee");
		 criteria.createAlias("request.project", "project");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
		            .add(Projections.property("request.projectId").as("projectId"))
		            .add(Projections.property("request.status").as("status"))
		            .add(Projections.property("request.useMaterialDate").as("useMaterialDate"))
		            .add(Projections.property("request.requestMaterialNo").as("requestMaterialNo"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("project.status").as("prostatus"))
		            .add(Projections.property("request.requestDate").as("requestDate"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.or(Restrictions.eq("request.status","Waiting Confirm")));	 
		 criteria.add(Restrictions.and(Restrictions.eq("request.projectId",mapping.getProjectId())));
		 criteria.add(Restrictions.or(Restrictions.ne("project.status", "Project Complete"),Restrictions.isNull("project.status")));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterialMapping> RequestMaterialList = (ArrayList<RequestMaterialMapping>) criteria.list();
		return RequestMaterialList;
	}
	

	@Override
	public ArrayList<RequestMaterial> CountWaitconfirmRequestMaterialPM() {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 criteria.createAlias("request.project", "project");
		 criteria.createAlias("request.employee", "employee");
		 ProjectionList projections = Projections.projectionList()
				     .add(Projections.property("project.status").as("prostatus"))
		            .add(Projections.count("request.requestMaterialId").as("requestMaterialNumber")); 
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("request.status","Waiting Confirm"));
		 criteria.add(Restrictions.or(Restrictions.ne("project.status", "Project Complete"),Restrictions.isNull("project.status")));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterial> RequestMaterialList = (ArrayList<RequestMaterial>) criteria.list();
		return RequestMaterialList;
	}
	
	
	@Override
	public ArrayList<RequestMaterial> FindWaitconfirmRequestMaterialPM() {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 criteria.createAlias("request.project", "project");
		 criteria.createAlias("request.employee", "employee");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
		            .add(Projections.property("request.projectId").as("projectId"))
		            .add(Projections.property("request.status").as("status"))
		            .add(Projections.property("request.requestMaterialNo").as("requestMaterialNo"))
		            .add(Projections.property("request.useMaterialDate").as("useMaterialDate"))
		            .add(Projections.property("request.requestDate").as("requestDate"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("project.status").as("prostatus"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("project.projectName").as("projectName"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("request.status","Waiting Confirm"));
		 criteria.add(Restrictions.or(Restrictions.ne("project.status", "Project Complete"),Restrictions.isNull("project.status")));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterial> RequestMaterialList = (ArrayList<RequestMaterial>) criteria.list();
		 System.out.println(RequestMaterialList);
		return RequestMaterialList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<RequestMaterial> CountRequestMaterial() {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 criteria.createAlias("request.project", "project");
		 ProjectionList projections = Projections.projectionList()				  
				   .add(Projections.property("project.status").as("prostatus"))
				   .add(Projections.count("request.requestMaterialId").as("requestMaterialId"));		 
		 criteria.setProjection(projections);	
		 criteria.add(Restrictions.eq("request.status","Waiting Material"));
		 criteria.add(Restrictions.or(Restrictions.ne("project.status", "Project Complete"),Restrictions.isNull("project.status")));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		ArrayList<RequestMaterial> requestList = (ArrayList<RequestMaterial>) criteria.list();
		return requestList;
	}
	
	
	@Override
	public ArrayList<RequestMaterialMapping> listRequestMaterialStock(RequestMaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 criteria.createAlias("request.project", "project");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
		            .add(Projections.property("request.projectId").as("projectId"))
		            .add(Projections.property("request.status").as("status"))
		            .add(Projections.property("request.requestMaterialNo").as("requestMaterialNo"))
		            .add(Projections.property("request.requestDate").as("requestDate"))
		            .add(Projections.property("project.status").as("prostatus"))
		            .add(Projections.property("project.projectName").as("projectName"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.or(Restrictions.eq("request.status","Waiting Material")));
		 criteria.add(Restrictions.or(Restrictions.ne("project.status", "Project Complete"),Restrictions.isNull("project.status")));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterialMapping> RequestMaterialList = (ArrayList<RequestMaterialMapping>) criteria.list();
		return RequestMaterialList;
	}
	
	@Override
	public ArrayList<RequestMaterialMapping> FindRequestMaterial(RequestMaterialMapping  mapping) {
		 Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
		            .add(Projections.property("request.status").as("status"))
		            .add(Projections.property("request.contactOwner").as("contactOwner"))
		            .add(Projections.property("request.requestMaterialNo").as("requestMaterialNo"))
		            .add(Projections.property("request.useMaterialDate").as("useMaterialDate"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("request.requestMaterialId",mapping.getRequestMaterialId()));	
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterialMapping> RequestMaterialList = (ArrayList<RequestMaterialMapping>) criteria.list();
		return RequestMaterialList;
	}
	
	@Override
	public RequestMaterial findRequestMaterialForUpdateStatus(RequestMaterialMapping mapping) {
		Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("request.employeeId").as("employeeId"))
				 .add(Projections.property("request.projectId").as("projectId"))
		          .add(Projections.property("request.requestMaterialNo").as("requestMaterialNo"))
		          .add(Projections.property("request.requestDate").as("requestDate"))
		          .add(Projections.property("request.contactOwner").as("contactOwner"))
		          .add(Projections.property("request.useMaterialDate").as("useMaterialDate"))
				 .add(Projections.property("request.status").as("status"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("request.requestMaterialId", mapping.getRequestMaterialId()));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial .class));
		 RequestMaterial  resultList =  (RequestMaterial ) criteria.uniqueResult();
		return resultList;
	}
	
	
	@Override
	public RequestMaterial findRequestMaterialForUpdateStatus(int id) {
		Criteria criteria = getSession().createCriteria(RequestMaterial.class, "request");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("request.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("request.employeeId").as("employeeId"))
				 .add(Projections.property("request.projectId").as("projectId"))
		          .add(Projections.property("request.requestMaterialNo").as("requestMaterialNo"))
		          .add(Projections.property("request.requestDate").as("requestDate"))
		          .add(Projections.property("request.contactOwner").as("contactOwner"))
		          .add(Projections.property("request.useMaterialDate").as("useMaterialDate"))
				 .add(Projections.property("request.status").as("status"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("request.requestMaterialId",id));
		 criteria.setResultTransformer(Transformers.aliasToBean(RequestMaterial .class));
		 RequestMaterial  resultList =  (RequestMaterial ) criteria.uniqueResult();
		return resultList;
	}
	
	
	
	
	
}
