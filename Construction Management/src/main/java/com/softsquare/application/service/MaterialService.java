package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.entity.Material;
import com.softsquare.application.entity.Stock;

public interface MaterialService {
	

	public ArrayList<Material> getMaterial(int typeId);
	 public  ArrayList<MaterialMapping> findMaterial(MaterialMapping materialmap);
	 public ArrayList<Material> AllMaterial();
	 public void saveMaterial(MaterialMapping mapping) throws Exception;
	 public void removeMaterial(MaterialMapping mapping) throws Exception;
	 public void updateMaterial(MaterialMapping mapping) throws Exception ;
	 public ArrayList<Stock> getMaterialformStock(int typeId);
}
