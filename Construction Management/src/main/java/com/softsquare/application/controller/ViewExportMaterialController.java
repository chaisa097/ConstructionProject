package com.softsquare.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.ExportMaterialMapping;
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.service.ExportMaterialDetailService;
import com.softsquare.application.service.ExportMaterialService;


@RestController
@RequestMapping("/viewExportMaterial.html")
@Configurable
public class ViewExportMaterialController {
	
	@Autowired
	ExportMaterialDetailService exportDetailServ;
	@Autowired
	ExportMaterialService exportSev;	
	
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ExportMaterialMapping mapping ){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("viewExportMaterial");
    	if(BeanUtils.isNotNull(mapping.getExportMaterialId())){
    		mav.addObject("headerId",mapping.getExportMaterialId());
    	}
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }
	
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
    public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ExportMaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(exportDetailServ.listExportMaterialDetail(mapping.getExportMaterialId()));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=searchHeader" , method=RequestMethod.POST)
    public void searchHeader(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ExportMaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(exportSev.listExportMaterial(mapping.getExportMaterialId()));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=ok" , method=RequestMethod.POST)
    public void sendAndUpdateStatus(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ExportMaterialMapping mapping) throws Throwable{
		exportSev.updateStatusConfirm(mapping.getExportMaterialId());
	}

}
