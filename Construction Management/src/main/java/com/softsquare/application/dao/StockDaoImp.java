package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.domain.StockMapping;
import com.softsquare.application.entity.Material;
import com.softsquare.application.entity.ReceiveMaterial;
import com.softsquare.application.entity.Stock;
@Repository()
@Component
public class StockDaoImp  extends AbstractDao<Integer, Stock> implements StockDao{

	@Override
	public ArrayList<Stock> FindMaterialInStock(int Id) {
		 Criteria criteria = getSession().createCriteria(Stock.class, "stock");		 
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("stock.stockId").as("stockId"))
		            .add(Projections.property("stock.materialId").as("materialId"))
		            .add(Projections.property("stock.price").as("price"))
		            .add(Projections.property("stock.totalQuatity").as("totalQuatity"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("stock.materialId",Id));
		 criteria.setResultTransformer(Transformers.aliasToBean(Stock.class));
		 ArrayList<Stock> stockList = (ArrayList<Stock>) criteria.list();
		return stockList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findMaterialIdInStock(int Id) {
		 Criteria criteria = getSession().createCriteria(Stock.class, "stock");		 
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("stock.stockId").as("stockId"))
		            .add(Projections.property("stock.materialId").as("materialId"))
		            .add(Projections.property("stock.price").as("price"))
		            .add(Projections.property("stock.totalQuatity").as("totalQuatity"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("stock.materialId",Id));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<StockMapping> getMaterialinStock(StockMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Stock.class, "stock");
		  criteria.createAlias("stock.material", "material");
		  criteria.createAlias("material.type", "type");
		  criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()
				    .add(Projections.property("stock.materialId").as("materialId"))
		            .add(Projections.property("stock.totalQuatity").as("totalQuatity"))
		            .add(Projections.property("type.typeId").as("typeId"))
		            .add(Projections.property("material.materialCode").as("materialCode"))
		            .add(Projections.property("material.materialName").as("materialName"));		 
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("stock.materialId",mapping.getMaterialId()));
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<StockMapping> materialList = (ArrayList<StockMapping>) criteria.list();		 
		return materialList;
	}
	
	
	@Override
	public void updateStock(Stock stock) throws Exception {
		merge(stock);
	}
	
	
	@Override
	public void saveStock(Stock stock) throws Exception {
		save(stock);
	}
	
	@Override
	public ArrayList<StockMapping> findByType(StockMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Stock.class,"stock");	
		 criteria.createAlias("stock.material","material");
		 criteria.createAlias("material.type","type");
		 criteria.createAlias("material.unit","unit");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("stock.stockId").as("stockId"))
		            .add(Projections.property("stock.materialId").as("materialId"))
		            .add(Projections.property("stock.totalQuatity").as("totalQuatity"))
		            .add(Projections.property("stock.price").as("price"))
		            .add(Projections.property("material.materialName").as("materialName"))
		            .add(Projections.property("material.description").as("description"))
		            .add(Projections.property("type.typeName").as("typeName"))
		            .add(Projections.property("type.typeId").as("typeId"))
	                .add(Projections.property("unit.unitName").as("unitName"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("type.typeId", mapping.getTypeId()));	
		 criteria.setResultTransformer(Transformers.aliasToBean(Stock.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<StockMapping> stockList = (ArrayList<StockMapping>) criteria.list();
		return stockList;
	}
	
	@Override
	public ArrayList<StockMapping> findAllStock(StockMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Stock.class,"stock");	
		 criteria.createAlias("stock.material","material");
		 criteria.createAlias("material.type","type");
		 criteria.createAlias("material.unit","unit");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("stock.stockId").as("stockId"))
		            .add(Projections.property("stock.materialId").as("materialId"))
		            .add(Projections.property("stock.totalQuatity").as("totalQuatity"))
		            .add(Projections.property("stock.price").as("price"))
		            .add(Projections.property("material.materialName").as("materialName"))
		            .add(Projections.property("material.description").as("description"))
		            .add(Projections.property("type.typeName").as("typeName"))
		            .add(Projections.property("type.typeId").as("typeId"))
	                .add(Projections.property("unit.unitName").as("unitName"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Stock.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<StockMapping> stockList = (ArrayList<StockMapping>) criteria.list();
		return stockList;
	}
	
	@Override
	public ArrayList<StockMapping> findMaterialPriceFormStock(StockMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Stock.class,"stock");	
		 criteria.createAlias("stock.material","material");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("stock.stockId").as("stockId"))
		            .add(Projections.property("stock.materialId").as("materialId"))
		            .add(Projections.property("stock.totalQuatity").as("totalQuatity"))
		            .add(Projections.property("stock.price").as("price"));

		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("stock.materialId", mapping.getMaterialId()));	
		 criteria.setResultTransformer(Transformers.aliasToBean(Stock.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<StockMapping> stockList = (ArrayList<StockMapping>) criteria.list();
		return stockList;
	}
	
	
}
