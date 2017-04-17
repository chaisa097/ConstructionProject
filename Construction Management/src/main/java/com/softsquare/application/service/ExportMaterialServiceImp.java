package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.dao.ExportMaterialDao;
import com.softsquare.application.dao.ExportMaterialDetailDao;
import com.softsquare.application.dao.LoginDao;
import com.softsquare.application.dao.RequestMaterialDao;
import com.softsquare.application.dao.StockDao;
import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.entity.ExportMaterial;
import com.softsquare.application.entity.ExportMaterialDetail;
import com.softsquare.application.entity.Stock;

@Service 
public class ExportMaterialServiceImp implements ExportMaterialService {

	@Autowired
	LoginDao  loginDao;
	@Autowired
	StockDao stockdao;
	@Autowired
    RequestMaterialDao requestDao;	
	@Autowired
    ExportMaterialDao exportMaterialDao;
	@Autowired
    ExportMaterialDetailDao exportMaterialDetailDao;	
	
	@Override
	public void saveExportMaterial(ExportMaterialMapping exportmapping) throws Exception {
		
		ExportMaterial  export = new ExportMaterial();
		Date  correntdate = new Date();
		export.setExportDate(correntdate);
		Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
		export.setEmployeeId((Integer) dataLogin.get("employeeId"));
		  Map<String, Object> request = requestDao.findRequestId(exportmapping.getRequestMaterialId());
		export.setRequestMaterialId((Integer) request.get("requestMaterialId"));
		Map<String, Object>  No  = exportMaterialDao.findNoExportMax();
		  if(BeanUtils.isNull(No.get("exportMaterialNo"))){
	    export.setExportMaterialNo("000001");
		  }
		  else{
			   Integer exportNo = Integer.parseInt((String) No.get("exportMaterialNo"))+1;
			   String expotyNoString = String.format("%06d", exportNo);
	    export.setExportMaterialNo(expotyNoString);  
		  }
		  Map<String, Object> exportMaterialId = exportMaterialDao.findExportbyRequestId(exportmapping.getRequestMaterialId());
		  
		  if(BeanUtils.isNotEmpty(exportMaterialId)){
			  Map<String, Object> Id = exportMaterialDao.findExportbyRequestId(exportmapping.getRequestMaterialId());
			 ExportMaterial  exportObj =  exportMaterialDao.findExportMaterialForUpdate((int) Id.get("exportMaterialId"));
			 exportMaterialDao.updateExport(exportObj);
			ExportMaterialDetail exportdetail = new ExportMaterialDetail();
			 exportdetail.setMaterialId(exportmapping.getMaterialId());
			 exportdetail.setExportId((int) Id.get("exportMaterialId"));
			 exportdetail.setExportQuantity(exportmapping.getExportQuantity());
			 exportMaterialDetailDao.saveExportDetail(exportdetail);
			  ArrayList<Stock> StockArry = stockdao.FindMaterialInStock(exportmapping.getMaterialId());
			 if(StockArry.size() == 1){
	        	 Stock stock = StockArry.get(0);
	    		if(BeanUtils.isNotNull(stock.getTotalQuatity())){
	    			stock.setTotalQuatity(stock.getTotalQuatity()-exportmapping.getExportQuantity());
	    		    stockdao.updateStock(stock);
	    		}
	    	 }
		  }
		  else{
			  exportMaterialDao.saveExport(export);
			  Map<String, Object> Id = exportMaterialDao.findExportbyRequestId(exportmapping.getRequestMaterialId());
			  ExportMaterialDetail exportdetail = new ExportMaterialDetail();
				 exportdetail.setMaterialId(exportmapping.getMaterialId());
				 exportdetail.setExportId((int) Id.get("exportMaterialId"));
				 exportdetail.setExportQuantity(exportmapping.getExportQuantity());
				 exportMaterialDetailDao.saveExportDetail(exportdetail);
				 
				  ArrayList<Stock> StockArry = stockdao.FindMaterialInStock(exportmapping.getMaterialId());
				 if(StockArry.size() == 1){
		        	 Stock stock = StockArry.get(0);
		    		if(BeanUtils.isNotNull(stock.getTotalQuatity())){
		    			stock.setTotalQuatity(stock.getTotalQuatity()-exportmapping.getExportQuantity());
		    			stockdao.updateStock(stock);
		    	 }
			  
		     }
		  
		  
		  }
	
      } //end
	
	
	
	
	
	
	
	
	}
