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
import com.softsquare.application.domain.ReceiveMaterialMapping;
import com.softsquare.application.domain.RequestMaterialDetailMapping;
import com.softsquare.application.domain.StockMapping;
import com.softsquare.application.service.ExportMaterialDetailService;
import com.softsquare.application.service.ExportMaterialService;
import com.softsquare.application.service.RequestMaterialDetailService;
import com.softsquare.application.service.StockService;

@RestController
@RequestMapping("/ExportMaterial.html")
@Configurable
public class ExportMaterialController {

    
	@Autowired
	 private RequestMaterialDetailService requestDetailService;
	
	@Autowired
	 private ExportMaterialService exportMaterialService;
	@Autowired
	 private  StockService stockServ;
	@Autowired
	 private  ExportMaterialDetailService exportDetailService;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response ,@ModelAttribute RequestMaterialDetailMapping mapping){		
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("exportMaterial");
    	if(BeanUtils.isNotNull(mapping.getRequestMaterialId())){
    		mav.addObject("headerId",mapping.getRequestMaterialId());
    	}
	return ControllerDefault.DefaultModelAndView(mav, request);
    }
	
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
    public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialDetailMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(requestDetailService.ListRequestDetail(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=save" , method=RequestMethod.POST)
    public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ExportMaterialMapping mapping) throws Throwable{
		exportMaterialService.saveExportMaterial(mapping);
	
         
	}
	
	
	@RequestMapping(params =  "method=searchMaterial", method=RequestMethod.POST)
    public void searchMaterial(HttpServletRequest request, HttpServletResponse response, @ModelAttribute StockMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(stockServ.getMaterialinStock(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=searchExport", method=RequestMethod.POST)
    public void searchReceiveMaterial(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ExportMaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(exportDetailService.ReceiveMaterialDetail(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	
}
