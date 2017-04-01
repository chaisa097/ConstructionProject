package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.entity.Material;

public interface MaterialService {
	

	public ArrayList<Material> getMaterial(int typeId);
}
