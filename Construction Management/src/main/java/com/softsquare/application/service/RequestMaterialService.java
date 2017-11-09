package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.RequestMaterialMapping;
import com.softsquare.application.entity.RequestMaterial;

public interface RequestMaterialService {

	
	public void saveRequest(RequestMaterialMapping requestmapping) throws Exception;
	public ArrayList<RequestMaterial> getRequestMaterial();
	public ArrayList<RequestMaterialMapping> FindRequestMaterial(RequestMaterialMapping  mapping);
	public void updateStatus(RequestMaterialMapping mapping) throws Exception;
	public ArrayList<RequestMaterial> ListconfirmRequestMaterial();
	public ArrayList<RequestMaterialMapping> ListconfirmRequestMaterialPM(RequestMaterialMapping mapping);
	public void updateStatusConfirmed(RequestMaterialMapping mapping) throws Exception;
	public void updateStatusReject(RequestMaterialMapping mapping) throws Exception;
	public ArrayList<RequestMaterialMapping> ListRequestMaterialToStock(RequestMaterialMapping mapping);
	public ArrayList<RequestMaterial> CountRequestMaterial();
	public ArrayList<RequestMaterial> CountWaitconfirmRequestMaterialPM();
	public ArrayList<RequestMaterial> FindWaitconfirmRequestMaterialPM();
}
