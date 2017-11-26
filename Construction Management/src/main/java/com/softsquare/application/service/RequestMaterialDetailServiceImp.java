package com.softsquare.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.RequestMaterialDetailDao;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.domain.RequestMaterialDetailMapping;
import com.softsquare.application.domain.WorkingMapping;
import com.softsquare.application.entity.Project;
import com.softsquare.application.entity.RequestMaterialDetail;

@Service 
public class RequestMaterialDetailServiceImp implements RequestMaterialDetailService{
	@Autowired
	private RequestMaterialDetailDao  redetailDao;

	@Override
	public void saveRequestDetail(RequestMaterialDetailMapping mapping) throws Exception {
		
		RequestMaterialDetail  reDetail = new  RequestMaterialDetail();
		reDetail.setRequestMaterialId(mapping.getRequestMaterialId());
		reDetail.setMaterialId(mapping.getMaterialId());
		reDetail.setQuantityRequest(mapping.getQuantityRequest());
		redetailDao.RequestDetailSave(reDetail);
		
	}
	
	@Override
	  public  ArrayList<RequestMaterialDetailMapping> ListRequestDetail(RequestMaterialDetailMapping mapping) {			
		return redetailDao.getRequestMaterialDetial(mapping);
	}
	
	@Override
	public void removeRequestDetail(RequestMaterialDetailMapping mapping) throws Exception {
		RequestMaterialDetail  reDetail = new  RequestMaterialDetail();
		reDetail.setRequestMaterialDetailId(mapping.getRequestMaterialDetailId());
		redetailDao.removeMaterialInRequestDetail(reDetail);
	}
	
	@Override
	public ArrayList<RequestMaterialDetail> findMaterialDetailId(int id)  {
		return  redetailDao.findMaterialDetailByRequestMaterialId(id);
	}
	@Override
	public ArrayList<RequestMaterialDetail> findMaterialDetailByRequestMaterialId(int RequestId){
		return  redetailDao.findMaterialDetailByRequestMaterialId(RequestId);
	}
}
