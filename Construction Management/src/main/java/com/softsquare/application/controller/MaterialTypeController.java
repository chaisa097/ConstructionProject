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
import com.softsquare.application.domain.MaterialTypeMapping;
import com.softsquare.application.service.TypeService;

@RestController
@RequestMapping("/type.html")
@Configurable
public class MaterialTypeController {
	
	@Autowired
	TypeService typeService;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("type");
	return ControllerDefault.DefaultModelAndView(mav, request);
	
}

	@RequestMapping(params =  "method=save" , method=RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialTypeMapping mapping) throws Throwable{
		typeService.saveType(mapping);
	}
	
	@RequestMapping(params =  "method=edit" , method=RequestMethod.POST)
	public void edit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialTypeMapping mapping) throws Throwable{
		typeService.updateType(mapping);
	}
	
	@RequestMapping(params =  "method=delete" , method=RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialTypeMapping mapping) throws Throwable{
		typeService.removeType(mapping);
	}
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
	public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialTypeMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(typeService.getMaterialType());
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	
	
	

}
