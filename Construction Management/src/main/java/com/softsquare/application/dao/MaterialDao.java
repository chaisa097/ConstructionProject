package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.entity.Material;

public interface MaterialDao {

	public ArrayList<Material> getMaterial(int typeId) ;
	
}
