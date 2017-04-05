package com.softsquare.application.dao;

import com.softsquare.application.entity.ReceiveMaterial;

public interface ReceiveMateriallDao {
	
	public void ReceiveMaterialSave(ReceiveMaterial receive) throws Exception;
	public void UpdateReceiveMaterial(ReceiveMaterial receive) throws Exception;

}
