package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.dao.ExportMaterialDao;
import com.softsquare.application.dao.ExportMaterialDetailDao;
import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.entity.ExportMaterialDetail;

@Service
public class ExportMaterialDetailServiceImp  implements ExportMaterialDetailService {
	
	@Autowired
    ExportMaterialDao exportMaterialDao;
	@Autowired
    ExportMaterialDetailDao exportMaterialDetailDao;	
	
	@Override
	public ArrayList<ExportMaterialDetail> ReceiveMaterialDetail(ExportMaterialMapping mapping){
		  Map<String, Object> exportMaterialId = exportMaterialDao.findExportbyRequestId(mapping.getRequestMaterialId());
		return exportMaterialDetailDao.getExportMaterialDetail((int) exportMaterialId.get("exportMaterialId"));
	}
	@Override
	public ArrayList<ExportMaterialDetail> listExportMaterialDetail(int id){
		return exportMaterialDetailDao.getExportMaterialDetail(id);
	}
	
	
}
