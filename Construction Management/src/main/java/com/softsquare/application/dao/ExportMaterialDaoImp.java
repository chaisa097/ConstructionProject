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
import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.entity.ExportMaterial;
import com.softsquare.application.entity.ReceiveMaterial;
import com.softsquare.application.entity.Stock;

@Repository()
@Component
public class ExportMaterialDaoImp extends AbstractDao<Integer,ExportMaterial> implements ExportMaterialDao{
	@Autowired
	 private LoginDao  loginDao;
	
	@Override
	public void saveExport(ExportMaterial export) throws Exception {
		save(export);
	}
	
	@Override
	public void updateExport(ExportMaterial export) throws Exception {
		merge(export);	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findNoExportMax() {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		 ProjectionList projections = Projections.projectionList()				  
		            .add(Projections.max("export.exportMaterialNo").as("exportMaterialNo"));		         		 
		 criteria.setProjection(projections);		
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findExportbyRequestId(int requestId){
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
		         .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
		         .add(Projections.property("export.totalExport").as("totalExport"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(requestId)){
			 criteria.add(Restrictions.eq("export.requestMaterialId",requestId));			 
		 }
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> OrderList = (Map<String, Object>) criteria.uniqueResult();
		return OrderList;
	}
	
	@Override
	public ExportMaterial findExportMaterialForUpdate (int Id) {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.projectId").as("projectId"))
				 .add(Projections.property("export.status").as("status"))
				 .add(Projections.property("export.totalExport").as("totalExport"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(Id)){
			 criteria.add(Restrictions.eq("export.requestMaterialId", Id));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(ExportMaterial.class));
		 ExportMaterial resultList =  (ExportMaterial) criteria.uniqueResult();
		return resultList;
	}
	
	
	
	
	@Override
	public ExportMaterial getExportMaterialForUpdate (ExportMaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.projectId").as("projectId"))
				 .add(Projections.property("export.status").as("status"))
				 .add(Projections.property("export.totalExport").as("totalExport"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getRequestMaterialId())){
			 criteria.add(Restrictions.eq("export.requestMaterialId", mapping.getRequestMaterialId()));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(ExportMaterial.class));
		 ExportMaterial resultList =  (ExportMaterial) criteria.uniqueResult();
		return resultList;
	}
	
	
	@Override
	public ExportMaterial getExportMaterialStatusForUpdate (int exportId) {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.projectId").as("projectId"))
				 .add(Projections.property("export.status").as("status"))
				 .add(Projections.property("export.totalExport").as("totalExport"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(exportId)){
			 criteria.add(Restrictions.eq("export.exportMaterialId", exportId));
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(ExportMaterial.class));
		 ExportMaterial resultList =  (ExportMaterial) criteria.uniqueResult();
		return resultList;
	}
	
	
	
	@Override
	public ArrayList<ExportMaterial> FindExportMaterialbyProjectId(ExportMaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		 criteria.createAlias("export.employee", "employee");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.projectId").as("projectId"))
				 .add(Projections.property("export.status").as("status"))
				 .add(Projections.property("employee.empFirstName").as("empFirstName"))
				 .add(Projections.property("employee.empLastName").as("empLastName"))
				 .add(Projections.property("export.totalExport").as("totalExport"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.and(Restrictions.eq("export.projectId",mapping.getProjectId()), Restrictions.eq("export.status","Confirmed")));
		 criteria.setResultTransformer(Transformers.aliasToBean(ExportMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<ExportMaterial> ExportMaterialList = (ArrayList<ExportMaterial>) criteria.list();
		return ExportMaterialList;
	}
	
	@Override
	public ArrayList<ExportMaterial> ListExportMaterialEngineer(ExportMaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.projectId").as("projectId"))
				 .add(Projections.property("export.status").as("status"))
				 .add(Projections.property("export.totalExport").as("totalExport"));
		 criteria.setProjection(projections);
		 Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
		 criteria.add(Restrictions.and(Restrictions.eq("export.projectId",mapping.getProjectId()), Restrictions.eq("export.status","Waiting Confirm"),Restrictions.eq("export.employeeId",dataLogin.get("employeeId"))));
		 criteria.setResultTransformer(Transformers.aliasToBean(ExportMaterial.class));
		 ArrayList<ExportMaterial> ExportMaterialList = (ArrayList<ExportMaterial>) criteria.list();
		return ExportMaterialList;
	}
	
	@Override
	public ArrayList<ExportMaterialMapping> listExport(ExportMaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		  criteria.createAlias("export.project", "project");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.projectId").as("projectId"))
				 .add(Projections.property("export.status").as("status"))
				 .add(Projections.property("export.totalExport").as("totalExport"))
		 .add(Projections.property("project.projectName").as("projectName"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("export.exportMaterialId",mapping.getExportId()));
		 criteria.setResultTransformer(Transformers.aliasToBean(ExportMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<ExportMaterialMapping> ExportMaterialList = (ArrayList<ExportMaterialMapping>) criteria.list();
		return ExportMaterialList;
	}
	
	
	
	
	
	
	@Override
	public ArrayList<ExportMaterial> listExportMaterial(int id) {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		  criteria.createAlias("export.project", "project");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.projectId").as("projectId"))
				 .add(Projections.property("export.status").as("status"))
				 .add(Projections.property("export.totalExport").as("totalExport"))
		 .add(Projections.property("project.projectName").as("projectName"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("export.exportMaterialId",id));
		 criteria.setResultTransformer(Transformers.aliasToBean(ExportMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<ExportMaterial> ExportMaterialList = (ArrayList<ExportMaterial>) criteria.list();
		return ExportMaterialList;
	}
	
	@Override
	public ArrayList<ExportMaterial> listAllExportMaterial() {
		 Criteria criteria = getSession().createCriteria(ExportMaterial.class, "export");
		  criteria.createAlias("export.project", "project");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("export.exportMaterialId").as("exportMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.projectId").as("projectId"))
				 .add(Projections.property("export.status").as("status"))
				 .add(Projections.property("export.totalExport").as("totalExport"))
		         .add(Projections.property("project.projectName").as("projectName"));
		 criteria.setProjection(projections);
		 Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
		 criteria.add(Restrictions.eq("export.employeeId",(int)dataLogin.get("employeeId")));
		 System.out.println((int)dataLogin.get("employeeId"));
		 criteria.setResultTransformer(Transformers.aliasToBean(ExportMaterial.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<ExportMaterial> ExportMaterialList = (ArrayList<ExportMaterial>) criteria.list();
		return ExportMaterialList;
	}
	
	
	
	
}
