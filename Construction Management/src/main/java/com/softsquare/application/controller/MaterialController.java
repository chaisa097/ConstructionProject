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
import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.service.MaterialService;

@RestController
@RequestMapping("/material.html")
@Configurable
public class MaterialController {
	
	@Autowired
	MaterialService materialService;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("material");
	return ControllerDefault.DefaultModelAndView(mav, request);
	
	}
	
	@RequestMapping(params =  "method=save" , method=RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialMapping mapping) throws Throwable{
		materialService.saveMaterial(mapping);
	}
	
	@RequestMapping(params =  "method=edit" , method=RequestMethod.POST)
	public void edit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialMapping mapping) throws Throwable{
		materialService.updateMaterial(mapping);
	}
	
	@RequestMapping(params =  "method=delete" , method=RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialMapping mapping) throws Throwable{
	 materialService.removeMaterial(mapping);
	}
	
	@RequestMapping(params =  "method=searchMaterialforUpdate" , method=RequestMethod.POST)
	public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson( materialService.findMaterial(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
	public void searchMaterialAll(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson( materialService.AllMaterial());
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	

}
