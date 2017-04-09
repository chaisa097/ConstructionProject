package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.MaterialDao;
import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.entity.Material;


@Service
public class MaterialServiceImp implements MaterialService {

	

	@Autowired
	private MaterialDao materialDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public ArrayList<Material> getMaterial(int typeId){
		return materialDao.getMaterial(typeId);
	}
    
	@Override
	public ArrayList<Material> AllMaterial(){
		return materialDao.getAllMaterial();
	}
	
	
	@Override
	  public  ArrayList<MaterialMapping> findMaterial(MaterialMapping materialmap) {			
		return materialDao.getMaterial(materialmap);
	}
	
	
}
