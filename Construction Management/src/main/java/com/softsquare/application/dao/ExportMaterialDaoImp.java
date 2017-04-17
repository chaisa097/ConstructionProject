package com.softsquare.application.dao;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.entity.ExportMaterial;
import com.softsquare.application.entity.ReceiveMaterial;

@Repository()
@Component
public class ExportMaterialDaoImp extends AbstractDao<Integer,ExportMaterial> implements ExportMaterialDao{

	
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
		         .add(Projections.property("export.exportMaterialId").as("exportMaterialId"));
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
				 .add(Projections.property("export.requestMaterialId").as("requestMaterialId"))
				 .add(Projections.property("export.employeeId").as("employeeId"))
				 .add(Projections.property("export.exportMaterialNo").as("exportMaterialNo"))
				 .add(Projections.property("export.exportDate").as("exportDate"))
		         .add(Projections.property("export.exportMaterialId").as("exportMaterialId"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("export.requestMaterialId", Id));
		 criteria.setResultTransformer(Transformers.aliasToBean(ReceiveMaterial.class));
		 ExportMaterial resultList =  (ExportMaterial) criteria.uniqueResult();
		return resultList;
	}
	
}
