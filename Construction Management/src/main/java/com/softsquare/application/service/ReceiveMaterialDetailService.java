package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ReceiveMaterialMapping;
import com.softsquare.application.entity.ReceiveMaterialDetail;

public interface ReceiveMaterialDetailService {

	public ArrayList<ReceiveMaterialDetail> ReceiveMaterialDetail(ReceiveMaterialMapping mapping);
	
}
