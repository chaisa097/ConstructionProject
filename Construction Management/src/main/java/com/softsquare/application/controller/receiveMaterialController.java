package com.softsquare.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.ProjectMapping;

@RestController
@RequestMapping("/receiveMaterial.html")
@Configurable
public class receiveMaterialController {

	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response , @ModelAttribute ProjectMapping mapping){		
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("receiveMaterial");
    	
	return ControllerDefault.DefaultModelAndView(mav, request);
}
	
	
	
}
