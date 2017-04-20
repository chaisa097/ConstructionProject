package com.softsquare.application.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.dao.ReceiveMaterialDetailDao;
import com.softsquare.application.dao.ReceiveMateriallDao;
import com.softsquare.application.dao.StockDao;
import com.softsquare.application.domain.ReceiveMaterialMapping;
import com.softsquare.application.entity.ReceiveMaterial;
import com.softsquare.application.entity.ReceiveMaterialDetail;
import com.softsquare.application.entity.Stock;
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
	@Autowired
	StockDao stockdao;
	
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
	   
	   if(BeanUtils.isNull(No.get("receiveMaterialNo"))){
		   receive.setReceiveMaterialNo("000001");	      
	   }else{
		   Integer ReceiveMaterialNo = Integer.parseInt((String) No.get("receiveMaterialNo"))+1;
		   String ReceiveNoString = String.format("%06d", ReceiveMaterialNo);
		   receive.setReceiveMaterialNo(ReceiveNoString);
		  }  
	   Map<String, Object> orderMaterialId  = receivematerialDao.findreceiveByorderId(mapping.getOrderMaterialId());
	    
	   if(BeanUtils.isNotEmpty(orderMaterialId)){
		    Map<String, Object>  id = receivematerialDao.findreceiveByorderId(mapping.getOrderMaterialId());
		    ReceiveMaterial  receiveObj = receivematerialDao.findReceiveForUpdate((int) id.get("receiveMaterialId"));
		    receivematerialDao.UpdateReceiveMaterial(receiveObj); 
		    ReceiveMaterialDetail rematerial = new ReceiveMaterialDetail();
		    rematerial.setMaterialId(mapping.getMaterialId());
		    rematerial.setReceiveQuantity(mapping.getReceiveQuantity());
		    rematerial.setReceivePrice(mapping.getReceivePrice());
		    rematerial.setReceiveId((Integer) id.get("receiveMaterialId"));
	        receiveDetailDao.ReceiveMaterialDetailSave(rematerial);
	        
	        
	        Map<String, Object>  material  = stockdao.findMaterialIdInStock(mapping.getMaterialId());
	        ArrayList<Stock> StockArry = stockdao.FindMaterialInStock(mapping.getMaterialId());
	        
	        if(BeanUtils.isNotEmpty(material)){
	        	if(StockArry.size() == 1){
	        	 Stock stock = StockArry.get(0);
	    		if(BeanUtils.isNotNull(stock.getTotalQuatity())){
	    			stock.setTotalQuatity(stock.getTotalQuatity()+mapping.getReceiveQuantity());
	    			 stock.setPrice(mapping.getReceivePrice());
	    		}else{
	    		    stock.setTotalQuatity(mapping.getReceiveQuantity());
	    		    stock.setPrice(mapping.getReceivePrice());
	    		}
	    		  stockdao.updateStock(stock);
	    	}
	        }else{
	        	   Stock newstock = new Stock();
				  newstock.setMaterialId(mapping.getMaterialId());
				  newstock.setTotalQuatity(mapping.getReceiveQuantity());
				  newstock.setPrice(mapping.getReceivePrice());
				  stockdao.saveStock(newstock);
	         }
	          	
	   }else{
		   
		   receivematerialDao.ReceiveMaterialSave(receive);
		   Map<String, Object>  id = receivematerialDao.findreceiveByorderId(mapping.getOrderMaterialId());
		   ReceiveMaterialDetail rematerial = new ReceiveMaterialDetail();
		   rematerial.setMaterialId(mapping.getMaterialId());
		   rematerial.setReceiveQuantity(mapping.getReceiveQuantity());
		   rematerial.setReceivePrice(mapping.getReceivePrice());
		   rematerial.setReceiveId((Integer) id.get("receiveMaterialId"));
	        receiveDetailDao.ReceiveMaterialDetailSave(rematerial);
	        
	        Map<String, Object>  material  = stockdao.findMaterialIdInStock(mapping.getMaterialId());
	        System.out.println(material);
	        ArrayList<Stock> StockArry = stockdao.FindMaterialInStock(mapping.getMaterialId());
	        
	        if(BeanUtils.isNotEmpty(material)){
	        	if(StockArry.size() == 1){
	        	 Stock stock = StockArry.get(0);
	    		if(BeanUtils.isNotNull(stock.getTotalQuatity())){
	    			stock.setTotalQuatity(stock.getTotalQuatity()+mapping.getReceiveQuantity());
	    			 stock.setPrice(mapping.getReceivePrice());
	    			
	    		}else{
	    		    stock.setTotalQuatity(mapping.getReceiveQuantity());
	    		    stock.setPrice(mapping.getReceivePrice());
	 
	    		}
	    		  stockdao.updateStock(stock);
	    	 }
	         }else{
	         	  Stock newstock = new Stock();
				  newstock.setMaterialId(mapping.getMaterialId());
				  newstock.setTotalQuatity(mapping.getReceiveQuantity());
				  newstock.setPrice(mapping.getReceivePrice());
				  stockdao.saveStock(newstock);
	         }
	   
	   
	   
	    }
	  
	   
    }
}
  

	


	
	   	      
	      
