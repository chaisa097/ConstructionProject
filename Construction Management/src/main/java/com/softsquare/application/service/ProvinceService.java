package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.Map;

import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.entity.Province;

public interface ProvinceService {

	public ArrayList<Province> getProvince();
	public void saveProvince(ProvinceMapping mapping) throws Exception ;
	public void removeProvince(ProvinceMapping mapping) throws Exception;
	public void updateProvince(ProvinceMapping mapping) throws Exception;
	public Map<String,Object> findProvince(ProvinceMapping mapping);
	
	
}
