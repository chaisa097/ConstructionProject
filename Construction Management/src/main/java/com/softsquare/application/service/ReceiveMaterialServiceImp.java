package com.softsquare.application.service;


import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.dao.ReceiveMaterialDetailDao;
import com.softsquare.application.dao.ReceiveMateriallDao;
import com.softsquare.application.domain.ReceiveMaterialMapping;
import com.softsquare.application.entity.ReceiveMaterial;
import com.softsquare.application.entity.ReceiveMaterialDetail;
import com.softsquare.application.dao.LoginDao;
import com.softsquare.application.dao.OrderMaterialDao;
@Service 
public class ReceiveMaterialServiceImp implements ReceiveMaterialService{

	@Autowired
	ReceiveMateriallDao receivematerialDao;
	
	@Autowired
	ReceiveMaterialDetailDao receiveDetailDao;
	@Autowired
	LoginDao  loginDao;
	@Autowired
	OrderMaterialDao  orderDao;
	
	@Override
	public void saveReceive(ReceiveMaterialMapping mapping) throws Exception {
	 
	   ReceiveMaterial  receive = new ReceiveMaterial();
	   Map<String, Object> orderId = orderDao.findOrderId(mapping.getOrderMaterialId());
	      receive.setOrderMaterialId((Integer) orderId.get("orderMaterialId"));
	   Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
		  receive.setEmployeeId((Integer) dataLogin.get("employeeId"));
	    Date  correntdate = new Date();
	      receive.setReceiveDate(correntdate);
	    Map<String, Object>  No  = receivematerialDao.findNoReceiveMax();
	    System.out.println(No+"----------------------------------");
	   
	   if(BeanUtils.isNull(No.get("receiveMaterialNo"))){
		   receive.setReceiveMaterialNo("000001");	      
	   }else{
		  Integer ReceiveMaterialNo = Integer.parseInt((String) No.get("receiveMaterialNo"))+1;
		  String ReceiveNoString = String.format("%06d", ReceiveMaterialNo);
		  receive.setReceiveMaterialNo(ReceiveNoString);
		  }  
	   Map<String, Object> orderMaterialId  = receivematerialDao.findOrderId(mapping.getOrderMaterialId());
	    System.out.println(orderMaterialId+"----------------------------------");
	    
	   if(BeanUtils.isNotEmpty(orderMaterialId)){
		   Map<String, Object>  id = receivematerialDao.findOrderId(mapping.getOrderMaterialId());
	       System.out.println(id+"++++++++++++++++++++++++++++++++++++++");
		   ReceiveMaterial  receiveObj = receivematerialDao.findReceiveForUpdate((int) id.get("receiveMaterialId"));
		   receivematerialDao.UpdateReceiveMaterial(receiveObj); 
		   ReceiveMaterialDetail rematerial = new ReceiveMaterialDetail();
		   rematerial.setMaterialId(mapping.getMaterialId());
		   rematerial.setReceiveQuantity(mapping.getReceiveQuantity());
		   rematerial.setReceivePrice(mapping.getReceivePrice());
		   rematerial.setReceiveId((Integer) id.get("receiveMaterialId"));
	        receiveDetailDao.ReceiveMaterialDetailSave(rematerial);
		   
	   }
	   else{
		   receivematerialDao.ReceiveMaterialSave(receive);
		   Map<String, Object>  id = receivematerialDao.findOrderId(mapping.getOrderMaterialId());
		   ReceiveMaterialDetail rematerial = new ReceiveMaterialDetail();
		   rematerial.setMaterialId(mapping.getMaterialId());
		   rematerial.setReceiveQuantity(mapping.getReceiveQuantity());
		   rematerial.setReceivePrice(mapping.getReceivePrice());
		   rematerial.setReceiveId((Integer) id.get("receiveMaterialId"));
	        receiveDetailDao.ReceiveMaterialDetailSave(rematerial);
	   }
	   
	   

	}}
  
	
	   	      
	      
