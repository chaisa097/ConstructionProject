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
import com.softsquare.application.dao.RequestMaterialDetailDao;

import com.softsquare.application.domain.RequestMaterialMapping;
import com.softsquare.application.dao.LoginDao;

import com.softsquare.application.entity.RequestMaterial;
import com.softsquare.application.entity.RequestMaterialDetail;

@Service
public class RequestMaterialServiceImp implements RequestMaterialService {

	@Autowired
	private RequestMaterialDao requestDao;	
		
	@Autowired
	private LoginDao loginDao;	
		
	@Autowired
	private RequestMaterialDetailDao  redetailDao;
	
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
	public ArrayList<RequestMaterial> CountWaitconfirmRequestMaterialPM(){
		 return requestDao.CountWaitconfirmRequestMaterialPM();
	}
	
	@Override
	public ArrayList<RequestMaterialMapping> ListRequestMaterialToStock(RequestMaterialMapping mapping) {
		  return requestDao.listRequestMaterialStock(mapping);
	
	}
	@Override
	public ArrayList<RequestMaterial> FindWaitconfirmRequestMaterialPM(){
		return requestDao.FindWaitconfirmRequestMaterialPM();
	}
	@Override
	public ArrayList<RequestMaterial> CountRequestMaterial() {
		return requestDao.CountRequestMaterial();
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
	public void updateRequest(RequestMaterialMapping mapping) throws Exception {
		RequestMaterial request =  requestDao.findRequestMaterialForUpdateStatus(mapping);
		requestDao.updateRequest(request);
	        
	}
	
	@Override
	public void updateStatusReject(RequestMaterialMapping mapping) throws Exception {
		RequestMaterial request =  requestDao.findRequestMaterialForUpdateStatus(mapping);
		request.setStatus("Reject");
		requestDao.updateRequest(request);
	        
	}
	
	@Override
	public void removeRequest(RequestMaterialMapping mapping) throws Exception {
		RequestMaterial  request = new RequestMaterial();
		request.setRequestMaterialId(mapping.getRequestMaterialId());
		System.out.println("555555555555"+mapping.getRequestMaterialId());
		ArrayList<RequestMaterialDetail> requestDetial = redetailDao.findMaterialDetailByRequestMaterialId(mapping.getRequestMaterialId());
		for(int i=0;i>requestDetial.size();i++) {
			RequestMaterialDetail  reDetail = new RequestMaterialDetail();
			reDetail.setRequestMaterialDetailId(requestDetial.get(i).getRequestMaterialDetailId());
			redetailDao.removeMaterialInRequestDetail(reDetail);
		}
		requestDao.removeRequest(request);
	}

	
	
	
}
