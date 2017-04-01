package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.entity.OrderMaterial;

public interface OrderMaterialService {

	public void saveOrder(OrderMaterialMapping ordermapping) throws Exception;
	public ArrayList<OrderMaterial> getOrderMaterial() ;
	
}
