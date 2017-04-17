package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.entity.ExportMaterialDetail;
import com.softsquare.application.entity.ReceiveMaterialDetail;

@Repository()
@Component
public class ExportMaterialDetailDaoImp extends AbstractDao<Integer,ExportMaterialDetail> implements ExportMaterialDetailDao {

	
	@Override
	public void saveExportDetail(ExportMaterialDetail exportdetail) throws Exception {
		save(exportdetail);
	}
	
	@Override
	public void updateExportDetail(ExportMaterialDetail exportdetail) throws Exception {
		merge(exportdetail);	
	}
	
	
	@Override
	public ArrayList<ExportMaterialDetail> getExportMaterialDetail(int exportId) {
		 Criteria criteria = getSession().createCriteria(ExportMaterialDetail.class, "exportDetail");
		 criteria.createAlias("exportDetail.material", "material");
		 criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()				
				    .add(Projections.property("exportDetail.exportQuantity").as("exportQuantity"))
			        .add(Projections.property("exportDetail.exportMateialDetialId").as("exportMateialDetialId"))
			        .add(Projections.property("exportDetail.exportId").as("exportId"))
			        .add(Projections.property("material.materialId").as("materialId"))
		            .add(Projections.property("material.materialName").as("materialName"))
		            .add(Projections.property("material.descrition").as("descrition"))
		            .add(Projections.property("unit.unitName").as("unitName"));		            
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("exportDetail.exportId",exportId ));	
		 criteria.setResultTransformer(Transformers.aliasToBean(ReceiveMaterialDetail.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<ExportMaterialDetail> resultList = (ArrayList<ExportMaterialDetail>) criteria.list();
		return resultList;
	}
	
	
	
}
