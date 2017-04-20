package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.entity.OrderMaterial;

public interface OrderMaterialService {

	public void saveOrder(OrderMaterialMapping ordermapping) throws Exception;
	public ArrayList<OrderMaterial> getOrderMaterial() ;
	public ArrayList<OrderMaterialMapping> findOrder(OrderMaterialMapping mapping);
	public void updateStatus(OrderMaterialMapping ordermapping) throws Exception;
	public ArrayList<OrderMaterial> getOrderMaterialWaitStatus();
	public void updateStatusConfirm(OrderMaterialMapping ordermapping) throws Exception ;
	public void updateStatusreject(OrderMaterialMapping ordermapping) throws Exception;
	public ArrayList<OrderMaterial> getOrderMaterialWaitMaterialStatus() ;
	public void updateStatusFinished(OrderMaterialMapping ordermapping) throws Exception;
	public ArrayList<OrderMaterial> getPmConfirmOrderMaterialWaitStatus();
	public ArrayList<OrderMaterial> getOrderFinish();
	
}
