package com.softsquare.application.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.entity.ReceiveMaterialDetail;
@Repository()
@Component
public class ReceiveMaterialDetailDaoImp extends AbstractDao<Integer, ReceiveMaterialDetail> implements ReceiveMaterialDetailDao {

	
	@Override
	public void ReceiveMaterialDetailSave(ReceiveMaterialDetail receiveDetail) throws Exception {
		save(receiveDetail);
	}
	@Override
	public void UpdateReceiveMaterialDetail(ReceiveMaterialDetail receiveDetail) throws Exception {
		merge(receiveDetail);
	}
	
	
}
