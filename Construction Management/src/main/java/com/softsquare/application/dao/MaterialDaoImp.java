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
import com.softsquare.application.domain.ManageRoleMapping;
import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.entity.Material;
import com.softsquare.application.entity.MaterialType;
import com.softsquare.application.entity.Role;
import com.softsquare.application.entity.Stock;


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
		            .add(Projections.property("type.typeId").as("typeId"))
		            .add(Projections.property("type.typeName").as("typeName"))
		            .add(Projections.property("unit.unitId").as("unitId"))
		            .add(Projections.property("unit.unitName").as("unitName"))
		            .add(Projections.property("material.description").as("description"))
		            .add(Projections.property("material.unitId").as("unitd"))
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
		            .add(Projections.property("type.typeName").as("typeName"))
		            .add(Projections.property("unit.unitName").as("unitName"))
		            .add(Projections.property("material.description").as("description"))
		            .add(Projections.property("material.unitId").as("unitd"))
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
	public ArrayList<Stock> getMaterialformStock(int typeId) {
		 Criteria criteria = getSession().createCriteria(Stock.class, "stock");
		  criteria.createAlias("stock.material", "material");
		  criteria.createAlias("material.type", "type");
		  criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()
				    .add(Projections.property("material.materialId").as("materialId"))
		            .add(Projections.property("stock.totalQuatity").as("totalQuatity"))
		            .add(Projections.property("unit.unitName").as("unitName"))
		            .add(Projections.property("material.unitId").as("unitId"))
		            .add(Projections.property("material.typeId").as("typeId"))
		            .add(Projections.property("material.materialCode").as("materialCode"))
		            .add(Projections.property("material.materialName").as("materialName"));		 
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("material.typeId",typeId));
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<Stock> stockList = (ArrayList<Stock>) criteria.list();		 
		return stockList;
	}
	
	
	
	
	
	@Override
	public ArrayList<MaterialMapping> getMaterial(MaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Material.class, "material");
		  criteria.createAlias("material.type", "type");
		  criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("material.materialId").as("materialId"))
		            .add(Projections.property("type.typeId").as("typeId"))
		            .add(Projections.property("type.typeName").as("typeName"))
		            .add(Projections.property("unit.unitId").as("unitId"))
		            .add(Projections.property("unit.unitName").as("unitName"))
		            .add(Projections.property("material.description").as("description"))
		            .add(Projections.property("material.materialCode").as("materialCode"))
		            .add(Projections.property("material.materialName").as("materialName"));		 
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("material.materialId",mapping.getMaterialId()));
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<MaterialMapping> materialList = (ArrayList<MaterialMapping>) criteria.list();		 
		return materialList;
	}
	
	@Override
	public Material getMaterialForUpdate(MaterialMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Material.class, "material");
		 ProjectionList projections = Projections.projectionList()
				    .add(Projections.property("material.materialId").as("materialId"))
				    .add(Projections.property("material.materialCode").as("materialCode"))
		            .add(Projections.property("material.materialName").as("materialName"))
		            .add(Projections.property("material.description").as("description"))
		            .add(Projections.property("material.unitId").as("unitId"))
		            .add(Projections.property("material.typeId").as("typeId"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getMaterialId())){
			 criteria.add(Restrictions.eq("material.materialId", mapping.getMaterialId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 Material matList = (Material) criteria.uniqueResult();
		return matList;
	}
	
	
	
	
	@Override
	public void SaveMaterial(Material m) throws Exception {
		save(m);
	}

	@Override
	public void UpdateMaterial(Material m) throws Exception {
		merge(m);
	}

	@Override
	public void DeleteMaterial(Material m) throws Exception {
		delete(m);
	}
	
}
