package com.softsquare.application.dao;
import java.util.ArrayList;

import com.softsquare.application.entity.ReceiveMaterialDetail;


public interface ReceiveMaterialDetailDao {
	
	public void ReceiveMaterialDetailSave(ReceiveMaterialDetail receiveDetail) throws Exception ;
	public void UpdateReceiveMaterialDetail(ReceiveMaterialDetail receiveDetail) throws Exception;
	public ArrayList<ReceiveMaterialDetail> getReceiveMaterialDetail() ;

}
