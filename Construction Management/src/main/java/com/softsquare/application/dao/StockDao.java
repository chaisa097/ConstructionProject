package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import com.softsquare.application.domain.StockMapping;
import com.softsquare.application.entity.Stock;

public interface StockDao {

	public ArrayList<Stock> FindMaterialInStock(int Id);
	public void updateStock(Stock stock) throws Exception;
	public void saveStock(Stock stock) throws Exception;
	public Map<String, Object> findMaterialIdInStock(int Id);
	public ArrayList<StockMapping> findAllStock(StockMapping mapping) ;
	public ArrayList<StockMapping> getMaterialinStock(StockMapping mapping); 
	public ArrayList<StockMapping> findMaterialPriceFormStock(StockMapping mapping);
	public ArrayList<StockMapping> findByType(StockMapping mapping);
	
	
}
