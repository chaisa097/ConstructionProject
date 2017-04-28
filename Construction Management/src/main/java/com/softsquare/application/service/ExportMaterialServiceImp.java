package com.softsquare.application.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;
import com.softsquare.application.dao.ExportMaterialDao;
import com.softsquare.application.dao.ExportMaterialDetailDao;
import com.softsquare.application.dao.LoginDao;
import com.softsquare.application.dao.ProjectDao;
import com.softsquare.application.dao.RequestMaterialDao;
import com.softsquare.application.dao.StockDao;
import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.ExportMaterial;
import com.softsquare.application.entity.ExportMaterialDetail;
import com.softsquare.application.entity.OrderMaterial;
import com.softsquare.application.entity.Project;
import com.softsquare.application.entity.Stock;
import com.softsquare.application.entity.RequestMaterial;

@Service
public class ExportMaterialServiceImp implements ExportMaterialService {

	@Autowired
	LoginDao loginDao;
	@Autowired
	StockDao stockdao;
	@Autowired
	RequestMaterialDao requestDao;
	@Autowired
	ExportMaterialDao exportMaterialDao;
	@Autowired
	ExportMaterialDetailDao exportMaterialDetailDao;

	@Autowired
	private ProjectDao projectDao;

	@Override
	public void saveExportMaterial(ExportMaterialMapping exportmapping) throws Exception {

		ExportMaterial export = new ExportMaterial();

		// set HeaderExportMaterial for Save
		Date correntdate = new Date();
		export.setExportDate(correntdate);
		Map<String, Object> request = requestDao.findRequestId(exportmapping.getRequestMaterialId());
		export.setRequestMaterialId((Integer) request.get("requestMaterialId"));
		export.setEmployeeId((Integer) request.get("employeeId"));
		export.setProjectId((Integer) request.get("projectId"));
		export.setStatus("Open");

		Map<String, Object> No = exportMaterialDao.findNoExportMax();
		// check exoportNo doesn't null
		if (BeanUtils.isNull(No.get("exportMaterialNo"))) {
			export.setExportMaterialNo("000001");
		} else {
			Integer exportNo = Integer.parseInt((String) No.get("exportMaterialNo")) + 1;
			String expotyNoString = String.format("%06d", exportNo);
			export.setExportMaterialNo(expotyNoString);
		}
		

		Map<String, Object> exportMaterialId = exportMaterialDao.findExportbyRequestId(exportmapping.getRequestMaterialId());
		
		//check if have material in database
		if (BeanUtils.isNotEmpty(exportMaterialId)) {
			Map<String, Object> Id = exportMaterialDao.findExportbyRequestId(exportmapping.getRequestMaterialId());
			ExportMaterial exportObj = exportMaterialDao.findExportMaterialForUpdate(exportmapping.getRequestMaterialId());
			Map<String, Object> stockObj = stockdao.findMaterialIdInStock(exportmapping.getMaterialId());
			int total = 0;
			total = (exportmapping.getExportQuantity() * (int) stockObj.get("price")); // calculate TotalExport
			exportObj.setTotalExport((int) Id.get("totalExport") + total);
			exportMaterialDao.updateExport(exportObj);
			// set export detail
			ExportMaterialDetail exportdetail = new ExportMaterialDetail();
			exportdetail.setMaterialId(exportmapping.getMaterialId());
			exportdetail.setExportId((int) Id.get("exportMaterialId"));
			exportdetail.setExportQuantity(exportmapping.getExportQuantity());
			exportMaterialDetailDao.saveExportDetail(exportdetail);

			// check material in stock 2 condition
			ArrayList<Stock> StockArry = stockdao.FindMaterialInStock(exportmapping.getMaterialId());
			if (StockArry.size() == 1) {// if stock have material
				Stock stock = StockArry.get(0);// call material that have 
				if (BeanUtils.isNotNull(stock.getTotalQuatity())) {
				stock.setTotalQuatity(stock.getTotalQuatity() - exportmapping.getExportQuantity());//remove quantity material form stock
					stockdao.updateStock(stock);
				}
			}

		} else {
			// calculate first item export
			Map<String, Object> stockObj = stockdao.findMaterialIdInStock(exportmapping.getMaterialId());
			int total = 0;
			// amount of export *price
			total = (exportmapping.getExportQuantity() * (int) stockObj.get("price"));
			export.setTotalExport(total);
			exportMaterialDao.saveExport(export);
			// save ExportDetail
			Map<String, Object> Id = exportMaterialDao.findExportbyRequestId(exportmapping.getRequestMaterialId());
			ExportMaterialDetail exportdetail = new ExportMaterialDetail();
			exportdetail.setMaterialId(exportmapping.getMaterialId());
			exportdetail.setExportId((int) Id.get("exportMaterialId"));
			exportdetail.setExportQuantity(exportmapping.getExportQuantity());
			exportMaterialDetailDao.saveExportDetail(exportdetail);
			// find for delete amount of material form stock
			ArrayList<Stock> StockArry = stockdao.FindMaterialInStock(exportmapping.getMaterialId());
			if (StockArry.size() == 1) {
				Stock stock = StockArry.get(0);
				if (BeanUtils.isNotNull(stock.getTotalQuatity())) {
					stock.setTotalQuatity(stock.getTotalQuatity() - exportmapping.getExportQuantity());
					stockdao.updateStock(stock);
				}

			}

		}

	} // end

	@Override
	public ArrayList<ExportMaterial> FindExportMaterialbyProjectId(ExportMaterialMapping mapping) {
		return exportMaterialDao.FindExportMaterialbyProjectId(mapping);
	}

	@Override
	public ArrayList<ExportMaterial> ListExportMaterialEngineer(ExportMaterialMapping mapping) {
		return exportMaterialDao.ListExportMaterialEngineer(mapping);
	}
	
	
	@Override
	public ArrayList<ExportMaterial> listExportMaterial(int id) {
		return exportMaterialDao.listExportMaterial(id);
	}
	@Override
	public ArrayList<ExportMaterial> listAllExportMaterial(){
		return exportMaterialDao.listAllExportMaterial();
   }
	@Override
	public void updatetotalUseMaterial(ProjectMapping mapping) throws Exception {
		Project pro = projectDao.findProejctForUpdate(mapping);
		pro.setTotalUseMaterial(mapping.getTotalUseMaterial());
		int totalexpense = 0;
		Map<String, Object> project = projectDao.findbugget(mapping.getProjectId());
		totalexpense = ((int) project.get("totalHireEmployee") + (int) project.get("totalUseMaterial"));
		pro.setTotalExpense(totalexpense);
		projectDao.updateProject(pro);
	}

	@Override
	public void updateStatus(ExportMaterialMapping mapping) throws Exception {
		ExportMaterial export = exportMaterialDao.getExportMaterialForUpdate(mapping);
		export.setStatus("Waiting Confirm");
		exportMaterialDao.updateExport(export);
		RequestMaterial reqMaterial = requestDao.findRequestMaterialForUpdateStatus(mapping.getRequestMaterialId());
		reqMaterial.setStatus("Finished");
		requestDao.updateRequest(reqMaterial);

	}
	
	
	@Override
	public void updateStatusConfirm(int id) throws Exception {
		ExportMaterial export = exportMaterialDao.getExportMaterialStatusForUpdate(id);
		export.setStatus("confirmed");
		exportMaterialDao.updateExport(export);

	}

}
