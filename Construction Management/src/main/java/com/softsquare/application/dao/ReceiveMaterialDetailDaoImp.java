package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.entity.ReceiveMaterialDetail;
import com.softsquare.application.entity.Role;
@Repository()
@Component
public class ReceiveMaterialDetailDaoImp extends AbstractDao<Integer, ReceiveMaterialDetail> implements ReceiveMaterialDetailDao {

	
	@Override
	public void ReceiveMaterialDetailSave(ReceiveMaterialDetail receiveDetail) throws Exception {
		save(receiveDetail);
	}
	@Override
	public void UpdateReceiveMaterialDetail(ReceiveMaterialDetail receiveDetail) throws Exception {
		merge(receiveDetail);
	}
	
	@Override
	public ArrayList<ReceiveMaterialDetail> getReceiveMaterialDetail(int receiveId) {
		 Criteria criteria = getSession().createCriteria(ReceiveMaterialDetail.class, "receiveDetail");
		 criteria.createAlias("receiveDetail.material", "material");
		 criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()				
				    .add(Projections.property("receiveDetail.receiveQuantity").as("receiveQuantity"))
		            .add(Projections.property("receiveDetail.receivePrice").as("receivePrice"))
			        .add(Projections.property("receiveDetail.receiveMateialDetialId").as("receiveMateialDetialId"))
			        .add(Projections.property("receiveDetail.receiveId").as("receiveId"))
			        .add(Projections.property("material.materialId").as("materialId"))
		            .add(Projections.property("material.materialName").as("materialName"))
		            .add(Projections.property("material.description").as("description"))
		            .add(Projections.property("unit.unitName").as("unitName"));		            
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("receiveDetail.receiveId",receiveId ));	
		 criteria.setResultTransformer(Transformers.aliasToBean(ReceiveMaterialDetail.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<ReceiveMaterialDetail> resultList = (ArrayList<ReceiveMaterialDetail>) criteria.list();
		return resultList;
	}
	
	
	
	
	
	
	
	
}
