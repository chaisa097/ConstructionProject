package com.softsquare.application.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.dao.LoginDao;
import com.softsquare.application.dao.OrderMaterialDao;
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.OrderMaterial;
import com.softsquare.application.entity.Project;

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
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
	    Date convertedDate = sdf.parse(ordermapping.getOrderMaterialDate());
	    order.setOrderMaterialDate(convertedDate);
	    order.setAddress(ordermapping.getAddress());
	    orderdao.saveOrder(order);
	    
	}
	
	@Override
	public ArrayList<OrderMaterial> getOrderMaterial() {
		return orderdao.getOrder();
	}
	
	@Override
	public ArrayList<OrderMaterial> getOrderMaterialWaitStatus() {
		return orderdao.getOrderWaitStatus();
	}
	@Override
	public ArrayList<OrderMaterial> getOrderMaterialWaitMaterialStatus() {
		return orderdao.getOrderWaitMaterialStatus();
	}
	
	@Override
	public ArrayList<OrderMaterialMapping> findOrder(OrderMaterialMapping mapping) {
		return orderdao.getFindOrder(mapping);
	}
	
	
	@Override
	public void updateStatus(OrderMaterialMapping ordermapping) throws Exception {
		OrderMaterial order =  orderdao.findOrderForUpdateStatus(ordermapping);
		order.setStatus("waiting confirm");
	    orderdao.updateOrder(order);
	        
	}
	@Override
	public void updateStatusConfirm(OrderMaterialMapping ordermapping) throws Exception {
		OrderMaterial order =  orderdao.findOrderForUpdateStatus(ordermapping);
		order.setStatus("Waiting Material");
	    orderdao.updateOrder(order);    	          
	}
	
	@Override
	public void updateStatusFinished(OrderMaterialMapping ordermapping) throws Exception {
		OrderMaterial order =  orderdao.findOrderForUpdateStatus(ordermapping);
		order.setStatus("Finished");
	    orderdao.updateOrder(order);    	          
	}
	
	@Override
	public void updateStatusreject(OrderMaterialMapping ordermapping) throws Exception {
		OrderMaterial order =  orderdao.findOrderForUpdateStatus(ordermapping);
		order.setStatus("reject");
	    orderdao.updateOrder(order);    	          
	}
	
	
	
}
