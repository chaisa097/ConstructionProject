package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.entity.Material;
import com.softsquare.application.entity.Stock;

public interface MaterialDao {

	public ArrayList<Material> getMaterial(int typeId) ;
	public ArrayList<MaterialMapping> getMaterial(MaterialMapping mapping);
	public ArrayList<Material> getAllMaterial() ;
	public void SaveMaterial(Material m) throws Exception;
	public void UpdateMaterial(Material m) throws Exception;
	public void DeleteMaterial(Material m) throws Exception;
	public Material getMaterialForUpdate(MaterialMapping mapping);
	public ArrayList<Stock> getMaterialformStock(int typeId) ;
}
