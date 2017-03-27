package com.softsquare.application.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.softsquare.application.dao.OrderMaterialDao;
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.OrderMaterial;
import com.softsquare.application.entity.Project;

@Service
public class OrderMaterialServiceImp implements OrderMaterialService{
	
	private OrderMaterialDao orderdao;
	
	@Override
	public void saveOrder(OrderMaterialMapping ordermapping) throws Exception {
	   OrderMaterial  order  = new OrderMaterial();
		order.setOrderMaterialNo(ordermapping.getOrderMaterialNo());
		order.setEmployeeId(ordermapping.getEmployeeId());
	    order.setStatus(ordermapping.getStatus());
	    orderdao.saveOrder(order);
	    
	}
}
