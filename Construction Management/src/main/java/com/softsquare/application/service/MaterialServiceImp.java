package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.MaterialDao;
import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.entity.Material;
import com.softsquare.application.entity.Role;
import com.softsquare.application.entity.Stock;


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
	public ArrayList<Stock> getMaterialformStock(int typeId) {
		return materialDao.getMaterialformStock(typeId);
	}
	
	@Override
	public ArrayList<Material> AllMaterial(){
		return materialDao.getAllMaterial();
	}
	
	
	@Override
	  public  ArrayList<MaterialMapping> findMaterial(MaterialMapping materialmap) {			
		return materialDao.getMaterial(materialmap);
	}
	
	@Override
	public void saveMaterial(MaterialMapping mapping) throws Exception {
		Material material = new Material();
		material.setMaterialName(mapping.getMaterialName());
		material.setMaterialCode(mapping.getMaterialCode());
		material.setDescrition(mapping.getDescription());
		material.setTypeId(mapping.getTypeId());
		material.setUnitId(mapping.getUnitId());
		materialDao.SaveMaterial(material);	
	}

	@Override
	public void removeMaterial(MaterialMapping mapping) throws Exception {
		Material material = new Material();
	     material.setMaterialId(mapping.getMaterialId());
		materialDao.DeleteMaterial(material);
	}

	@Override
	public void updateMaterial(MaterialMapping mapping) throws Exception {
		Material material = materialDao.getMaterialForUpdate(mapping);
		material.setMaterialCode(mapping.getMaterialCode());
		material.setDescrition(mapping.getDescription());
		material.setMaterialName(mapping.getMaterialName());
		material.setTypeId((mapping.getTypeId()));
		materialDao.UpdateMaterial(material);
	}
}
