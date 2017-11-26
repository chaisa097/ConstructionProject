package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.RequestMaterialDetailMapping;
import com.softsquare.application.entity.RequestMaterialDetail;

public interface RequestMaterialDetailService {

	public void saveRequestDetail(RequestMaterialDetailMapping mapping) throws Exception;
	 public  ArrayList<RequestMaterialDetailMapping> ListRequestDetail(RequestMaterialDetailMapping mapping);
	 public void removeRequestDetail(RequestMaterialDetailMapping mapping) throws Exception;
	 public ArrayList<RequestMaterialDetail> findMaterialDetailId(int id);
		public ArrayList<RequestMaterialDetail> findMaterialDetailByRequestMaterialId(int RequestId);
}
