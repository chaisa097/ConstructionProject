package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.entity.OrderMaterial;

public interface OrderMaterialDao {

	public void saveOrder(OrderMaterial order) throws Exception;
	public Map<String, Object> findNoMax() ;
	public ArrayList<OrderMaterial> getOrder();
	public ArrayList<OrderMaterialMapping> getFindOrder(OrderMaterialMapping mapping);
	public void updateOrder(OrderMaterial order) throws Exception;
	public OrderMaterial findOrderForUpdateStatus(OrderMaterialMapping mapping);
	public ArrayList<OrderMaterial> getOrderWaitStatus();
	public ArrayList<OrderMaterial> getOrderWaitMaterialStatus();
	public Map<String, Object> findOrderId(int orderId) ;
	public ArrayList<OrderMaterial> getPMConfirmOrderWaitStatus();
	public ArrayList<OrderMaterial> getOrderFinish();
	
}
