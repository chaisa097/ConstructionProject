package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.MaterialTypeDao;
import com.softsquare.application.domain.MaterialTypeMapping;
import com.softsquare.application.entity.MaterialType;

@Service
public class TypeServiceImp implements TypeService {
	
	
	@Autowired
	private MaterialTypeDao typeDao;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ArrayList<MaterialType> getMaterialType() {
		return typeDao.getType();
	}
	
	
	@Override
	public void saveType(MaterialTypeMapping mapping) throws Exception {
		MaterialType  type = new MaterialType();
		System.out.println(mapping.getTypeCode());
		System.out.println(mapping.getTypeName());
		type.setTypeCode(mapping.getTypeCode());
		type.setTypeName(mapping.getTypeName());
		typeDao.SaveMaterialType(type);
	}

	@Override
	public void removeType(MaterialTypeMapping mapping) throws Exception {
		MaterialType  type = new MaterialType();
	    type.setTypeId(mapping.getTypeId());
	    typeDao.DeleteMaterialType(type);
	}

	@Override
	public void updateType(MaterialTypeMapping mapping) throws Exception {
		MaterialType type = typeDao.getTypeForUpdate(mapping);
		type.setTypeCode(mapping.getTypeCode());
		type.setTypeName(mapping.getTypeName());
		typeDao.UpdateMaterialType(type);
	}
	

}
