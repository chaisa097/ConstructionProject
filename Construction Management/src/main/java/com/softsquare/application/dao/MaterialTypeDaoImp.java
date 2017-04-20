package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.MaterialTypeMapping;
import com.softsquare.application.entity.MaterialType;
import com.softsquare.application.entity.OrderDetail;
import com.softsquare.application.entity.Role;


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

	@Override
	public MaterialType getTypeForUpdate(MaterialTypeMapping mapping) {
		 Criteria criteria = getSession().createCriteria(MaterialType.class, "type");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("type.typeId").as("typeId"))
		            .add(Projections.property("type.typeCode").as("typeCode"))
		            .add(Projections.property("type.typeName").as("typeName"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getTypeId())){
			 criteria.add(Restrictions.eq("type.typeId", mapping.getTypeId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(MaterialType.class));
		 MaterialType resultList = (MaterialType) criteria.uniqueResult();
		return resultList;
	}
	
	
	

	@Override
	public void SaveMaterialType(MaterialType type) throws Exception {
		save(type);
	}

	@Override
	public void UpdateMaterialType(MaterialType type) throws Exception {
		merge(type);
	}

	@Override
	public void DeleteMaterialType(MaterialType type) throws Exception {
		delete(type);
	}

	
	

}
