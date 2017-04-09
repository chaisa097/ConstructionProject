package com.softsquare.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/createRequisitionMaterial.html")
@Configurable
public class CreateRequisitionController {

	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){		
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("createRequisitionMaterial");
    	
	return ControllerDefault.DefaultModelAndView(mav, request);
}
	
	
	
	
}
