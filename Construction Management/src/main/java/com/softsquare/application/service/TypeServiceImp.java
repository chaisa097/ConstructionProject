package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.MaterialTypeDao;
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

}
