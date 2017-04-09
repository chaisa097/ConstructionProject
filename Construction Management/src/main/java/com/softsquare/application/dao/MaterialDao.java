package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.entity.Material;

public interface MaterialDao {

	public ArrayList<Material> getMaterial(int typeId) ;
	public ArrayList<MaterialMapping> getMaterial(MaterialMapping mapping);
	public ArrayList<Material> getAllMaterial() ;
	
}
