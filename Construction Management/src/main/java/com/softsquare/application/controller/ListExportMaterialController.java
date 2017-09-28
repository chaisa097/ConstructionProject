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
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.service.ExportMaterialService;
import com.softsquare.application.service.ProjectService;

@RestController
@RequestMapping("/listExportMaterial.html")
@Configurable
public class ListExportMaterialController {
	@Autowired
	 private ExportMaterialService exportMaterialService;
	@Autowired
	ProjectService listprojectSevice;
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response ,@ModelAttribute ExportMaterialMapping mapping){		
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("listExportMaterial");
    	if(BeanUtils.isNotNull(mapping.getProjectId())){
    		mav.addObject("headerId",mapping.getProjectId());
    	}
	return ControllerDefault.DefaultModelAndView(mav, request);
    }
	
	@RequestMapping(params = "method=search", method=RequestMethod.POST)
	public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ExportMaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();	
		
		String  json = gson.toJson(exportMaterialService.FindExportMaterialbyProjectId(mapping));

		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}

		
	}
	
	@RequestMapping(params =  "method=UpdateTotalExport" , method=RequestMethod.POST)
    public void updateProject(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ProjectMapping project) throws Throwable{
		exportMaterialService.updatetotalUseMaterial(project);
	}
	
	@RequestMapping(params =  "method=searchTotalUseMaterial" , method=RequestMethod.POST)
    public void SeachProject(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ProjectMapping mapping) throws Throwable{
	Gson gson = new Gson();	
		
		String  json = gson.toJson(listprojectSevice.findProject(mapping) );

		 try {
			response.getWriter().write(json);
		 } catch (Exception e) {
				e.printStackTrace();
		 }

	 }
	
	
	
	
}
