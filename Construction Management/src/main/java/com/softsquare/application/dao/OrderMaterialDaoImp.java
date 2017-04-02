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

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.ManageRoleMapping;
import com.softsquare.application.entity.OrderMaterial;
import com.softsquare.application.entity.Role;

@Repository()
@Component
public class OrderMaterialDaoImp extends AbstractDao<Integer, OrderMaterial>   implements OrderMaterialDao{
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findNoMax() {
		 Criteria criteria = getSession().createCriteria(OrderMaterial.class, "order");
		 ProjectionList projections = Projections.projectionList()				  
		            .add(Projections.max("order.orderMaterialNo").as("orderMaterialNo"));		         		 
		 criteria.setProjection(projections);		
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
		
	@Override
	public void saveOrder(OrderMaterial order) throws Exception {
		save(order);
	}

	@Override
	public ArrayList<OrderMaterial> getOrder() {
		 Criteria criteria = getSession().createCriteria(OrderMaterial.class, "order");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("order.orderMaterialId").as("orderMaterialId"))
		            .add(Projections.property("order.orderMaterialNo").as("orderMaterialNo"))
		            .add(Projections.property("order.address").as("address"))
		            .add(Projections.property("order.orderMaterialDate").as("orderMaterialDate"))
		            .add(Projections.property("order.status").as("status"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(OrderMaterial.class));
		 ArrayList<OrderMaterial> orderList = (ArrayList<OrderMaterial>) criteria.list();
		return orderList;
	}
	
	
	
}

	
	
