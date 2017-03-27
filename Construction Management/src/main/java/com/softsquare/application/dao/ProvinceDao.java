package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.entity.Province;


public interface ProvinceDao {
	public ArrayList<Province> getProvince();
	public Province getProvinceForUpdate(ProvinceMapping mapping);
	public void saveProvince(Province province) throws Exception ;
	public void removeProvince(Province province) throws Exception;
	public void updateProvince(Province province) throws Exception;
	
	
	

}
