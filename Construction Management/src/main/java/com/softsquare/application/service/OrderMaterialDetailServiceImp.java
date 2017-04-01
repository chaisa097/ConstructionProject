package com.softsquare.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.OrderMaterialDetailDao;
import com.softsquare.application.domain.OrderMaterialDetailMapping;
import com.softsquare.application.entity.OderMaterialDetail;

@Service
public class OrderMaterialDetailServiceImp  implements OrderMaterialDetialService {
	
	@Autowired
	 private OrderMaterialDetailDao  orderDetailDao;  
	
	@Override
	public void saveOrdermaterialDetail(OrderMaterialDetailMapping mapping) throws Exception {
		OderMaterialDetail orderdetail = new OderMaterialDetail();
		orderdetail.setOrderMaterialId(mapping.getOrderMaterialId());
		orderdetail.setMaterialId(mapping.getMaterialId());
		orderdetail.setQuantityOrder(mapping.getQuantityOrder());
		orderdetail.setAnotation(mapping.getAnotation());
		 orderDetailDao.saveOrderMaterial(orderdetail);
	}
	

}
