package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.OrderMaterialDetailMapping;
import com.softsquare.application.entity.OderMaterialDetail;

public interface OrderMaterialDetailDao {

	public void saveOrderMaterial(OderMaterialDetail orderdetail) throws Exception;
	public ArrayList<OrderMaterialDetailMapping> getOrderMaterial(OrderMaterialDetailMapping  orderMapping);
	public void orderMaterialDetailDelete(OderMaterialDetail orderDetail) throws Exception;
}
