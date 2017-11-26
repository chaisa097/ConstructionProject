package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.domain.RequestMaterialDetailMapping;
import com.softsquare.application.entity.Material;
import com.softsquare.application.entity.RequestMaterialDetail;

@Repository()
@Component
public class RequestMaterialDetailDaolmp extends AbstractDao<Integer,RequestMaterialDetail> implements RequestMaterialDetailDao {

	

	@Override
	public void RequestDetailSave(RequestMaterialDetail requestDetail) throws Exception {
		save(requestDetail);
	}
	
	@Override
	public void removeMaterialInRequestDetail(RequestMaterialDetail requestDetail) throws Exception {
		delete(requestDetail);
	}
		
	@Override
	public ArrayList<RequestMaterialDetailMapping> getRequestMaterialDetial(RequestMaterialDetailMapping Mapping) {
		 Criteria criteria = getSession().createCriteria(RequestMaterialDetail.class, "reqMaterialDetail");
		  criteria.createAlias("reqMaterialDetail.requestMaterial", "requestMaterial");
		  criteria.createAlias("reqMaterialDetail.material", "material");
		  criteria.createAlias("material.unit", "unit");
		  criteria.createAlias("material.type", "type");
		 ProjectionList projections = Projections.projectionList()
				  .add(Projections.property("reqMaterialDetail.requestMaterialDetailId").as("requestMaterialDetailId"))
				  .add(Projections.property("reqMaterialDetail.quantityRequest").as("quantityRequest"))
				  .add(Projections.property("requestMaterial.requestMaterialId").as(" requestMaterialId"))
		          .add(Projections.property("material.materialId").as("materialId"))
		          .add(Projections.property("material.description").as("description"))
		          .add(Projections.property("material.materialName").as("materialName"))
		          .add(Projections.property("unit.unitName").as("unitName"))
		          .add(Projections.property("type.typeName").as("typeName"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("requestMaterial.requestMaterialId",Mapping.getRequestMaterialId()));
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterialDetailMapping> reqdetailList = (ArrayList<RequestMaterialDetailMapping>) criteria.list();		 
		return reqdetailList;
	}
	
	@Override
	public ArrayList<RequestMaterialDetail> findMaterialDetailByRequestMaterialId(int RequestId) {
		 Criteria criteria = getSession().createCriteria(RequestMaterialDetail.class, "reqMaterialDetail");
		  criteria.createAlias("reqMaterialDetail.requestMaterial", "requestMaterial");
		  criteria.createAlias("requestMaterial.project", "project");
		  criteria.createAlias("reqMaterialDetail.material", "material");
		  criteria.createAlias("material.unit", "unit");
		  criteria.createAlias("material.type", "type");
		 ProjectionList projections = Projections.projectionList()
				  .add(Projections.property("reqMaterialDetail.requestMaterialDetailId").as("requestMaterialDetailId"))
				  .add(Projections.property("reqMaterialDetail.quantityRequest").as("quantityRequest"))
				  .add(Projections.property("reqMaterialDetail.requestMaterialId").as(" requestMaterialId"))
		          .add(Projections.property("material.materialId").as("materialId"))
		          .add(Projections.property("material.description").as("description"))
		          .add(Projections.property("material.materialName").as("materialName"))
		          .add(Projections.property("unit.unitName").as("unitName"))
		          .add(Projections.property("project.projectId").as("projectId"))
		          .add(Projections.property("type.typeName").as("typeName"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("reqMaterialDetail.requestMaterialId",RequestId));
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<RequestMaterialDetail> reqdetailList = (ArrayList<RequestMaterialDetail>) criteria.list();		 
		return reqdetailList;
	}
	
	
}
