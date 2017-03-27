package com.softsquare.application.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.entity.OrderMaterial;



@Repository()
@Component
public class OrderMaterialDaoImp extends AbstractDao<Integer, OrderMaterial>   implements OrderMaterialDao{
	
	
	
	@Override
	public void saveOrder(OrderMaterial order) throws Exception {
		save(order);
	}

	
	
}

	
	
