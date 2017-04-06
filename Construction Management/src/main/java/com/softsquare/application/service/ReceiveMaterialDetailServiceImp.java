package com.softsquare.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.ReceiveMaterialDetailDao;
import com.softsquare.application.entity.ReceiveMaterialDetail;

@Service 
public class ReceiveMaterialDetailServiceImp implements ReceiveMaterialDetailService {

	@Autowired
	private ReceiveMaterialDetailDao receiveDetailDao;
	@Override
	public ArrayList<ReceiveMaterialDetail> ReceiveMaterialDetail(){
		return receiveDetailDao.getReceiveMaterialDetail();
	}
	
}
