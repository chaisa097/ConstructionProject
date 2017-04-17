package com.softsquare.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.StockDao;
import com.softsquare.application.domain.StockMapping;
import com.softsquare.application.entity.Stock;

@Service
public class StockServiceImp implements StockService {

	@Autowired
	private StockDao stockDao;
	
	@Override 
	public ArrayList<StockMapping> findAllStock(StockMapping mapping){
		return stockDao.findAllStock(mapping);
	}
	@Override 
	public ArrayList<StockMapping> getMaterialinStock(StockMapping mapping){
		return stockDao.getMaterialinStock(mapping);
	}
	
	
}
