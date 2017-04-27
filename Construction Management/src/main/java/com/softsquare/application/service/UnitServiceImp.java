package com.softsquare.application.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.UnitDao;
import com.softsquare.application.domain.UnitMapping;
import com.softsquare.application.entity.Unit;

@Service
public class UnitServiceImp implements UnitService{

	@Autowired
	private UnitDao unidao;
	

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public ArrayList<Unit> getUnit() {
		return unidao.getUnit();
	}
	
	
	@Override
	public void saveUnit(UnitMapping mapping) throws Exception {
		Unit  unit = new Unit();
		System.out.println(mapping.getUnitCode());
		System.out.println(mapping.getUnitName());
		unit.setUnitCode(mapping.getUnitCode());
		unit.setUnitName(mapping.getUnitName());
		unidao.SaveUnit(unit);
	}

	@Override
	public void removeUnit(UnitMapping mapping) throws Exception {
		Unit  unit = new Unit();
	    unit.setUnitId(mapping.getUnitId());
	    unidao.DeleteUnit(unit);
	}

	@Override
	public void updateUnit(UnitMapping mapping) throws Exception {
		Unit unit = unidao.getUnitForUpdate(mapping);
		unit.setUnitCode(mapping.getUnitCode());
		unit.setUnitName(mapping.getUnitName());
		unidao.UpdateUnit(unit);
	}
	
	
}
