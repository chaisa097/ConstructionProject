package com.softsquare.application.dao;
import com.softsquare.application.entity.ReceiveMaterialDetail;


public interface ReceiveMaterialDetailDao {
	
	public void ReceiveMaterialDetailSave(ReceiveMaterialDetail receiveDetail) throws Exception ;
	public void UpdateReceiveMaterialDetail(ReceiveMaterialDetail receiveDetail) throws Exception;

}
