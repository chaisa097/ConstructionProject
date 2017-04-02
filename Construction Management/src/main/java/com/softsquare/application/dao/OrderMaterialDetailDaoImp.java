package com.softsquare.application.dao;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.domain.OrderMaterialDetailMapping;
import com.softsquare.application.entity.Material;
import com.softsquare.application.entity.OderMaterialDetail;
import com.softsquare.application.entity.OrderDetail;


@Repository()
@Component
public class OrderMaterialDetailDaoImp extends AbstractDao<Integer, OderMaterialDetail> implements OrderMaterialDetailDao {
	
	@Override
	public void saveOrderMaterial(OderMaterialDetail orderdetail) throws Exception {
		save(orderdetail);
	}
	@Override
	public ArrayList<OrderMaterialDetailMapping> getOrderMaterial(OrderMaterialDetailMapping  orderMapping) {
		 Criteria criteria = getSession().createCriteria(OderMaterialDetail.class, "orderDetail");
		  criteria.createAlias("orderDetail.order", "order");
		  criteria.createAlias("orderDetail.material", "material");
		  criteria.createAlias("material.unit", "unit");
		 ProjectionList projections = Projections.projectionList()
				 .add(Projections.property("orderDetail.orderMaterialDatailId").as("orderMaterialDatailId"))
				     .add(Projections.property("order.orderMaterialId").as("orderMaterialId"))
				     .add(Projections.property("orderDetail.anotation").as("anotation"))
				    .add(Projections.property("orderDetail.quantityOrder").as("quantityOrder"))
		            .add(Projections.property("material.materialId").as("materialId"))
		            .add(Projections.property("material.descrition").as("descrition"))
		            .add(Projections.property("material.materialName").as("materialName"))
		            .add(Projections.property("unit.unitName").as("unitName"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("order.orderMaterialId",orderMapping.getOrderMaterialId()));
		 criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<OrderMaterialDetailMapping> orderdetailList = (ArrayList<OrderMaterialDetailMapping>) criteria.list();		 
		return orderdetailList;
	}
	
	
	@Override
	public void orderMaterialDetailDelete(OderMaterialDetail orderDetail) throws Exception {
		delete(orderDetail);
	}
	
}
