package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.ExportMaterial;

public interface ExportMaterialService {
	
	public void saveExportMaterial(ExportMaterialMapping exportmapping) throws Exception;
	public ArrayList<ExportMaterial> FindExportMaterialbyProjectId(ExportMaterialMapping mapping);
	public void updatetotalUseMaterial(ProjectMapping mapping) throws Exception;
	public void updateStatus(ExportMaterialMapping mapping) throws Exception;
	public ArrayList<ExportMaterial> ListExportMaterialEngineer(ExportMaterialMapping mapping);
	public ArrayList<ExportMaterial> listExportMaterial(int id);
	public void updateStatusConfirm(int id) throws Exception;
	public ArrayList<ExportMaterial> listAllExportMaterial();

}
