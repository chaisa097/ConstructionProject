package com.softsquare.application.dao;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.entity.OrderMaterial;
import com.softsquare.application.entity.ReceiveMaterial;

@Repository()
@Component
public class RecieveMaterialDaoImp extends AbstractDao<Integer, ReceiveMaterial> implements ReceiveMateriallDao{

	
	

	@Override
	public void ReceiveMaterialSave(ReceiveMaterial receive) throws Exception {
		save(receive);
	}
	@Override
	public void UpdateReceiveMaterial(ReceiveMaterial receive) throws Exception {
		merge(receive);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findNoReceiveMax() {
		 Criteria criteria = getSession().createCriteria(ReceiveMaterial.class, "receive");
		 ProjectionList projections = Projections.projectionList()				  
		            .add(Projections.max("receive.receiveMaterialNo").as("receiveMaterialNo"));		         		 
		 criteria.setProjection(projections);		
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findreceiveByorderId(int Id) {
		 Criteria criteria = getSession().createCriteria(ReceiveMaterial.class, "receive");
		 ProjectionList projections = Projections.projectionList()				  
				  .add(Projections.property("receive.receiveMaterialId").as("receiveMaterialId"))
				  .add(Projections.property("receive.orderMaterialId").as("orderMaterialId"))					 
			      .add(Projections.property("receive.receiveMaterialNo").as("receiveMaterialNo"));
		 criteria.setProjection(projections);	
		 criteria.add(Restrictions.eq("receive.orderMaterialId",Id));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
	
	
	  
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findReceiveIdByNoId(String No) {
		 Criteria criteria = getSession().createCriteria(ReceiveMaterial.class, "receive");
		 ProjectionList projections = Projections.projectionList()
				      .add(Projections.property("receive.receiveMaterialId").as("receiveMaterialId"))
				      .add(Projections.property("receive.receiveMaterialNo").as("receiveMaterialNo"));	         		 
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("receive.receiveMaterialNo",No));		
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
	
	
	@Override
	public ReceiveMaterial findReceiveForUpdate (int Id) {
		Criteria criteria = getSession().createCriteria(ReceiveMaterial.class, "receive");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("receive.receiveMaterialId").as("receiveMaterialId"))
				 .add(Projections.property("receive.employeeId").as("employeeId"))
				 .add(Projections.property("receive.receiveMaterialNo").as("receiveMaterialNo"))
		          .add(Projections.property("receive.receiveDate").as("receiveDate"))
		          .add(Projections.property("receive.orderMaterialId").as("orderMaterialId"));
				 
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("receive.receiveMaterialId", Id));
		 criteria.setResultTransformer(Transformers.aliasToBean(ReceiveMaterial.class));
		 ReceiveMaterial resultList =  (ReceiveMaterial) criteria.uniqueResult();
		return resultList;
	}
	
}
