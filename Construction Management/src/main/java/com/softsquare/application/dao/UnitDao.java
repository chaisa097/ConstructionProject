package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.UnitMapping;
import com.softsquare.application.entity.Unit;

public interface UnitDao {

	public ArrayList<Unit> getUnit();
	public Unit getUnitForUpdate(UnitMapping mapping);
	public void SaveUnit(Unit unit) throws Exception;
	public void UpdateUnit(Unit unit) throws Exception;
	public void DeleteUnit(Unit unit) throws Exception;
	



	
}
