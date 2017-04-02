package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.OrderMaterialDetailMapping;
import com.softsquare.application.entity.OderMaterialDetail;


public interface OrderMaterialDetialService {
	
	public void saveOrdermaterialDetail(OrderMaterialDetailMapping mapping) throws Exception ;
	public ArrayList<OrderMaterialDetailMapping> getOrderMaterialDetail(OrderMaterialDetailMapping mapping);
	public void removeOrderMaterial(OrderMaterialDetailMapping mapping) throws Exception;

}
