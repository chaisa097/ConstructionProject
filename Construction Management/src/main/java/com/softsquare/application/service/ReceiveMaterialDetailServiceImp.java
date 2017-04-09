package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softsquare.application.dao.ReceiveMateriallDao;
import com.softsquare.application.dao.ReceiveMaterialDetailDao;
import com.softsquare.application.domain.ReceiveMaterialMapping;
import com.softsquare.application.entity.ReceiveMaterialDetail;

@Service 
public class ReceiveMaterialDetailServiceImp implements ReceiveMaterialDetailService {

	@Autowired
	private ReceiveMaterialDetailDao receiveDetailDao;
	
	@Autowired
	private ReceiveMateriallDao receiveDao;
	
	@Override
	public ArrayList<ReceiveMaterialDetail> ReceiveMaterialDetail(ReceiveMaterialMapping mapping){
		Map<String, Object> receive = receiveDao.findOrderId(mapping.getOrderMaterialId());
		System.out.println(receive+"000000000000000000000000000000000");
		return receiveDetailDao.getReceiveMaterialDetail((int) receive.get("receiveMaterialId"));
	}
	
	
	
}
