package com.softsquare.application.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.OrderMaterialDao;
import com.softsquare.application.dao.OrderMaterialDetailDao;
import com.softsquare.application.domain.OrderMaterialDetailMapping;
import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.entity.OderMaterialDetail;
import com.softsquare.application.entity.OrderMaterial;
import com.softsquare.application.entity.Province;

@Service
public class OrderMaterialDetailServiceImp  implements OrderMaterialDetialService {
	
	@Autowired
	 private OrderMaterialDetailDao  orderDetailDao; 

	
	@Override
	public void saveOrdermaterialDetail(OrderMaterialDetailMapping mapping) throws Exception {
		OderMaterialDetail orderdetail = new OderMaterialDetail();
		System.out.println("==============="+orderdetail.getOrderMaterialId());
		orderdetail.setOrderMaterialId(mapping.getOrderMaterialId());
		orderdetail.setMaterialId(mapping.getMaterialId());
		orderdetail.setQuantityOrder(mapping.getQuantityOrder());
		orderdetail.setAnotation(mapping.getAnotation());
		 orderDetailDao.saveOrderMaterial(orderdetail);
	}
	@Override
	public ArrayList<OrderMaterialDetailMapping> getOrderMaterialDetail(OrderMaterialDetailMapping mapping){
		return  orderDetailDao.getOrderMaterial(mapping);
	}
	
	@Override
	public void removeOrderMaterial(OrderMaterialDetailMapping mapping) throws Exception {
		OderMaterialDetail orderdetail = new OderMaterialDetail();
		orderdetail.setOrderMaterialDatailId(mapping.getOrderMaterialDatailId());
		orderDetailDao.orderMaterialDetailDelete(orderdetail);
	}
	
}
