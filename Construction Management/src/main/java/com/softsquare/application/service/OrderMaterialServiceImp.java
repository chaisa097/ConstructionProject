package com.softsquare.application.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.dao.LoginDao;
import com.softsquare.application.dao.OrderMaterialDao;
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.entity.OrderMaterial;

@Service
public class OrderMaterialServiceImp implements OrderMaterialService{
	
	@Autowired
	private OrderMaterialDao orderdao;	
	@Autowired
	 private LoginDao  loginDao;
	
	
	@Override
	public void saveOrder(OrderMaterialMapping ordermapping) throws Exception {
	   OrderMaterial  order  = new OrderMaterial();
	    Map<String, Object>  No  = orderdao.findNoMax();
	    System.out.println(No+"----------------------------------");
	    System.out.println(No.get("orderMaterialNo"));
	   if(BeanUtils.isNull(No.get("orderMaterialNo"))){		 
		   order.setOrderMaterialNo("000001");	    	
	    }
	   else {
		  Integer MaterialNo = Integer.parseInt((String) No.get("orderMaterialNo"))+1;
		  String MaterialNoString = String.format("%06d", MaterialNo);		   
		  order.setOrderMaterialNo(MaterialNoString);
		   
	   }
			
		Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
		System.out.println(dataLogin+"-------------------------------------------");
		order.setEmployeeId((Integer) dataLogin.get("employeeId"));
	    order.setStatus("Open");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date convertedDate = sdf.parse(ordermapping.getOrderMaterialDate());
	    order.setOrderMaterialDate(convertedDate);
	    order.setAddress(ordermapping.getAddress());
	    orderdao.saveOrder(order);
	    
	}
	
	@Override
	public ArrayList<OrderMaterial> getOrderMaterial() {
		return orderdao.getOrder();
	}
	
	
	
	
}
