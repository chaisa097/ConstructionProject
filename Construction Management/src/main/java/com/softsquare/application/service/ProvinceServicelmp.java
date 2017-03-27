package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.ProvinceDao;
import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.entity.Province;

@Service 
public class ProvinceServicelmp implements ProvinceService {

	@Autowired
	 private ProvinceDao provinceDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Override
	public ArrayList<Province> getProvince() {
		return provinceDao.getProvince();
	}
	
	@Override
	public void saveProvince(ProvinceMapping mapping) throws Exception {
		Province province = new Province();
		System.out.println(mapping.getProvinceCode());
		System.out.println(mapping.getProvinceName());
		province.setProviceCode(mapping.getProvinceCode());
		province.setProvinceName(mapping.getProvinceName());
		provinceDao.saveProvince(province);
	}
	
	@Override
	public void removeProvince(ProvinceMapping mapping) throws Exception {
		Province province = new Province();
		province.setProvinceId(mapping.getProvinceId());
		provinceDao.removeProvince(province);
	}
	
	@Override
	public void updateProvince(ProvinceMapping mapping) throws Exception {
		Province province = provinceDao.getProvinceForUpdate(mapping);
		province.setProviceCode(mapping.getProvinceCode());
		province.setProvinceName(mapping.getProvinceName());
		provinceDao.updateProvince(province);
	}
	
	
	
}
