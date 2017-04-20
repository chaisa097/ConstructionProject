package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.MaterialTypeMapping;
import com.softsquare.application.entity.MaterialType;

public interface TypeService {

	public ArrayList<MaterialType> getMaterialType(); 
	public void saveType(MaterialTypeMapping mapping) throws Exception;
	public void removeType(MaterialTypeMapping mapping) throws Exception;
	public void updateType(MaterialTypeMapping mapping) throws Exception;
	
}
