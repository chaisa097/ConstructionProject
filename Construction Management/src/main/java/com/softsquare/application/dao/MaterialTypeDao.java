package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.MaterialTypeMapping;
import com.softsquare.application.entity.MaterialType;

public interface MaterialTypeDao {

	public ArrayList<MaterialType> getType();
	public void SaveMaterialType(MaterialType type) throws Exception;
	public void UpdateMaterialType(MaterialType type) throws Exception;
	public void DeleteMaterialType(MaterialType type) throws Exception;
	public MaterialType getTypeForUpdate(MaterialTypeMapping mapping);
}
