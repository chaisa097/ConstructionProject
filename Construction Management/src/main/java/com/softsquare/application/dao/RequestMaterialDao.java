package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import com.softsquare.application.domain.RequestMaterialMapping;
import com.softsquare.application.entity.RequestMaterial;

public interface RequestMaterialDao {
	
	public void RequestSave(RequestMaterial request) throws Exception;
	public Map<String, Object> findRequestNoMax();
	public ArrayList<RequestMaterial> getRequestMaterial();
	public ArrayList<RequestMaterialMapping> FindRequestMaterial(RequestMaterialMapping  mapping);
	public RequestMaterial findRequestMaterialForUpdateStatus(RequestMaterialMapping mapping);
	public void updateRequest(RequestMaterial request) throws Exception;
	public ArrayList<RequestMaterialMapping> listWaitconfirmRequestMaterialPM(RequestMaterialMapping mapping);
	public ArrayList<RequestMaterial> listWaitconfirmRequestMaterial();
	public ArrayList<RequestMaterialMapping> listRequestMaterialStock(RequestMaterialMapping mapping);
	public Map<String, Object> findRequestId(int requestId);
	
} 
