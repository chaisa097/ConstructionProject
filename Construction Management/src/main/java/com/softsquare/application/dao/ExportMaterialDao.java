package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.entity.ExportMaterial;

public interface ExportMaterialDao {

	public void saveExport(ExportMaterial export) throws Exception;
	public void updateExport(ExportMaterial export) throws Exception;
	public Map<String, Object> findNoExportMax();
	public Map<String, Object> findExportbyRequestId(int rquestId);
	public ExportMaterial findExportMaterialForUpdate (int Id);
	public ArrayList<ExportMaterial> FindExportMaterialbyProjectId(ExportMaterialMapping mapping);
	public ExportMaterial getExportMaterialForUpdate (ExportMaterialMapping mapping);
	public ArrayList<ExportMaterial> ListExportMaterialEngineer(ExportMaterialMapping mapping);
	public ArrayList<ExportMaterial> listExportMaterial(ExportMaterialMapping mapping) ;
}
