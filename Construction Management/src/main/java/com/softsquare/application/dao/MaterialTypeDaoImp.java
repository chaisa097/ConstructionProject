package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.softsquare.application.entity.MaterialType;


@Repository()
@Component
public class MaterialTypeDaoImp  extends AbstractDao<Integer, MaterialType> implements MaterialTypeDao{
		

	@Override
	public ArrayList<MaterialType> getType() {
		 Criteria criteria = getSession().createCriteria(MaterialType.class, "type");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("type.typeId").as("typeId"))
		            .add(Projections.property("type.typeCode").as("typeCode"))
		            .add(Projections.property("type.typeName").as("typeName"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(MaterialType.class));		 
		 ArrayList<MaterialType> typeList = (ArrayList<MaterialType>) criteria.list();
		return typeList;
	}

	
	

}
