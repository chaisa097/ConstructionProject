package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.entity.Material;

public interface MaterialService {
	

	public ArrayList<Material> getMaterial(int typeId);
	 public  ArrayList<MaterialMapping> findMaterial(MaterialMapping materialmap);
	 public ArrayList<Material> AllMaterial();
}
