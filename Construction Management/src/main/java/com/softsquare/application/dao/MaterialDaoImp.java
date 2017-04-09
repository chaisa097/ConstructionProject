package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.entity.Material;


@Repository()
@Component
public class MaterialDaoImp extends AbstractDao<Integer, Material> implements MaterialDao  {
       
	
	@Override
	public ArrayList<Material> getAllMaterial() {
		 Criteria criteria = getSession().createCriteria(Material.class, "material");
		  criteria.createAlias("material.type", "type");
		  criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("material.materialId").as("materialId"))
		            .add(Projections.property("material.materialCode").as("materialCode"))
		            .add(Projections.property("material.materialName").as("materialName"));		 
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<Material> materialList = (ArrayList<Material>) criteria.list();		 
		return materialList;
	}
	
	
	
	
	
	@Override
	public ArrayList<Material> getMaterial(int typeId) {
		 Criteria criteria = getSession().createCriteria(Material.class, "material");
		  criteria.createAlias("material.type", "type");
		  criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("material.materialId").as("materialId"))
		            .add(Projections.property("type.typeId").as("typeId"))
		            .add(Projections.property("material.materialCode").as("materialCode"))
		            .add(Projections.property("material.materialName").as("materialName"));		 
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("typeId",typeId));
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<Material> materialList = (ArrayList<Material>) criteria.list();		 
		return materialList;
	}
	
	
	@Override
	public ArrayList<MaterialMapping> getMaterial(MaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Material.class, "material");
		  criteria.createAlias("material.type", "type");
		  criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("material.materialId").as("materialId"))
		            .add(Projections.property("type.typeId").as("typeId"))
		            .add(Projections.property("material.materialCode").as("materialCode"))
		            .add(Projections.property("material.materialName").as("materialName"));		 
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("material.materialId",mapping.getMaterialId()));
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<MaterialMapping> materialList = (ArrayList<MaterialMapping>) criteria.list();		 
		return materialList;
	}
	
	
	
}
