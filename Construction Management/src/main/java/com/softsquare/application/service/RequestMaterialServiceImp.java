package com.softsquare.application.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.dao.RequestMaterialDao;
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.domain.RequestMaterialMapping;
import com.softsquare.application.dao.LoginDao;
import com.softsquare.application.entity.OrderMaterial;
import com.softsquare.application.entity.RequestMaterial;
@Service
public class RequestMaterialServiceImp implements RequestMaterialService {

	@Autowired
	private RequestMaterialDao requestDao;	
		
	@Autowired
	private LoginDao loginDao;	
		
	
	@Override
	public void saveRequest(RequestMaterialMapping requestmapping) throws Exception {
		RequestMaterial  request  = new RequestMaterial();
	    Map<String, Object>  No  = requestDao.findRequestNoMax();
	    System.out.println(No+"----------------------------------");
	    System.out.println(No.get("requestMaterialNo"));
	   if(BeanUtils.isNull(No.get("requestMaterialNo"))){		 
		  request.setRequestMaterialNo("000001");	    	
	    }
	   else {
		  Integer requestNo = Integer.parseInt((String) No.get("requestMaterialNo"))+1;
		  String requestNoString = String.format("%06d",requestNo);		   
		 request.setRequestMaterialNo(requestNoString);
		   
	   }
			
		Map<String, Object> dataLogin = loginDao.findByLOGID(LoginUtils.getUsername());
		System.out.println(dataLogin+"-------------------------------------------");
		System.out.println((Integer) dataLogin.get("employeeId")+"///////-88888");
		request.setEmployeeId((Integer) dataLogin.get("employeeId"));
		request.setStatus("Open");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
	    Date convertedDate = sdf.parse(requestmapping.getUseMaterialDate());
	    request.setUseMaterialDate(convertedDate);
	    Date  createdate =  new Date();
	    request.setRequestDate(createdate);
	    request.setProjectId(requestmapping.getProjectId());
	    request.setContactOwner(requestmapping.getContactOwner());
	    requestDao.RequestSave(request);
	    
	}
	
	@Override
	public ArrayList<RequestMaterial> getRequestMaterial() {
		  return requestDao.getRequestMaterial();
	
	}
	
	@Override
	public ArrayList<RequestMaterial> ListconfirmRequestMaterial() {
		  return requestDao.listWaitconfirmRequestMaterial();
	
	}
	
	@Override
	public ArrayList<RequestMaterialMapping> ListconfirmRequestMaterialPM(RequestMaterialMapping mapping) {
		  return requestDao.listWaitconfirmRequestMaterialPM(mapping);
	
	}
	
	@Override
	public ArrayList<RequestMaterialMapping> ListRequestMaterialToStock(RequestMaterialMapping mapping) {
		  return requestDao.listRequestMaterialStock(mapping);
	
	}
	
	
	
	@Override
	public ArrayList<RequestMaterialMapping> FindRequestMaterial(RequestMaterialMapping  mapping){
		return  requestDao.FindRequestMaterial(mapping);
	}
	
	@Override
	public void updateStatus(RequestMaterialMapping mapping) throws Exception {
		RequestMaterial request =  requestDao.findRequestMaterialForUpdateStatus(mapping);
		request.setStatus("Waiting Confirm");
		requestDao.updateRequest(request);
	        
	}
	
	@Override
	public void updateStatusConfirmed(RequestMaterialMapping mapping) throws Exception {
		RequestMaterial request =  requestDao.findRequestMaterialForUpdateStatus(mapping);
		request.setStatus("Waiting Material");
		requestDao.updateRequest(request);
	        
	}
	
	@Override
	public void updateStatusReject(RequestMaterialMapping mapping) throws Exception {
		RequestMaterial request =  requestDao.findRequestMaterialForUpdateStatus(mapping);
		request.setStatus("Reject");
		requestDao.updateRequest(request);
	        
	}
	
	
	
	
	
}
