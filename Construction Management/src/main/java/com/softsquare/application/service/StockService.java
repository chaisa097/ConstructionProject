package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.StockMapping;

public interface StockService {

	
	public ArrayList<StockMapping> findAllStock(StockMapping mapping);
}
