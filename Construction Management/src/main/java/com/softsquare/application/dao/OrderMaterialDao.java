package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import com.softsquare.application.entity.OrderMaterial;

public interface OrderMaterialDao {

	public void saveOrder(OrderMaterial order) throws Exception;
	public Map<String, Object> findNoMax() ;
	public ArrayList<OrderMaterial> getOrder();
	
}
