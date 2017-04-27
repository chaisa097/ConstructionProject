package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.UnitMapping;
import com.softsquare.application.entity.Unit;

public interface UnitService {

	public ArrayList<Unit> getUnit();
	public void saveUnit(UnitMapping mapping) throws Exception;
	public void removeUnit(UnitMapping mapping) throws Exception;
	public void updateUnit(UnitMapping mapping) throws Exception;



}
