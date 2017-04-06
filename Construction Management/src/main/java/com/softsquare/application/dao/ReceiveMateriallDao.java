package com.softsquare.application.dao;

import java.util.Map;

import com.softsquare.application.entity.ReceiveMaterial;

public interface ReceiveMateriallDao {
	
	public void ReceiveMaterialSave(ReceiveMaterial receive) throws Exception;
	public void UpdateReceiveMaterial(ReceiveMaterial receive) throws Exception;
	public Map<String, Object> findNoReceiveMax() ;
	public Map<String, Object> findReceiveIdByNoId(String No);
	public ReceiveMaterial findReceiveForUpdate (int Id);
	public Map<String, Object> findOrderId(int Id);

}
