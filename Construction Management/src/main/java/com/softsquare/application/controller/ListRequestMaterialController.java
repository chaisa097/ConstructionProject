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
import com.softsquare.application.domain.RequestMaterialMapping;
import com.softsquare.application.service.RequestMaterialService;

@RestController
@RequestMapping("/listRequestMaterial.html")
@Configurable
public class ListRequestMaterialController {
	
	@Autowired
	RequestMaterialService RequestService;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("listRequestMaterial");
	return ControllerDefault.DefaultModelAndView(mav, request);
	}
	
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
	public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(RequestService.ListconfirmRequestMaterial());
//		System.out.print(json);
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}

   }
}