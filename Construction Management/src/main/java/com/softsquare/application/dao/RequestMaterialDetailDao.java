package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.RequestMaterialDetailMapping;
import com.softsquare.application.entity.RequestMaterialDetail;

public interface RequestMaterialDetailDao {

	public void RequestDetailSave(RequestMaterialDetail requestDetail) throws Exception;
	public void removeMaterialInRequestDetail(RequestMaterialDetail requestDetail) throws Exception;
	public ArrayList<RequestMaterialDetailMapping> getRequestMaterialDetial(RequestMaterialDetailMapping Mapping);
	public ArrayList<RequestMaterialDetail> findMaterialDetailByRequestMaterialId(int RequestId);
}
