package com.softsquare.application.dao;

import java.util.ArrayList;

import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.entity.ExportMaterialDetail;

public interface ExportMaterialDetailDao {
	
	public void saveExportDetail(ExportMaterialDetail exportdetail) throws Exception;
	public void updateExportDetail(ExportMaterialDetail exportdetail) throws Exception;
	public ArrayList<ExportMaterialDetail> getExportMaterialDetail(int exportId);
	public ArrayList<ExportMaterialDetail> listExportMaterialDetail(int id);

}
