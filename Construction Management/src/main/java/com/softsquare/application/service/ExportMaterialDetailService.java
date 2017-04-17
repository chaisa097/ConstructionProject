package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.entity.ExportMaterialDetail;

public interface ExportMaterialDetailService {

	public ArrayList<ExportMaterialDetail> ReceiveMaterialDetail(ExportMaterialMapping mapping);
}
