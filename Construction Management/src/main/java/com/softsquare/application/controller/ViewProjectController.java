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
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.domain.WorkingMapping;
import com.softsquare.application.service.ProjectService;
import com.softsquare.application.service.WorkingService;

@RestController
@RequestMapping("/viewProject.html")
@Configurable
public class ViewProjectController {
	
	@Autowired
	ProjectService listprojectSevice;
	@Autowired
	WorkingService workingSevice;
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response,@ModelAttribute ProjectMapping mapping){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("viewProject");
    	if (BeanUtils.isNotNull(mapping.getProjectId())){
            mav.addObject("headerId",mapping.getProjectId());
      	}
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }

	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
    public void SeachProject(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ProjectMapping mapping) throws Throwable{
	Gson gson = new Gson();	
		
		String  json = gson.toJson(listprojectSevice.findProject(mapping) );

		 try {
			response.getWriter().write(json);
		 } catch (Exception e) {
				e.printStackTrace();
		 }

		
	 }
	
	@RequestMapping(params =  "method=searchWorker" , method=RequestMethod.POST)
    public void Seachworker(HttpServletRequest request, HttpServletResponse response, @ModelAttribute WorkingMapping mapping) throws Throwable{
	Gson gson = new Gson();	
		
		String  json = gson.toJson(workingSevice.findWorker(mapping));

		 try {
			response.getWriter().write(json);
		 } catch (Exception e) {
				e.printStackTrace();
		 }

		
	 }
	
	
	
	
}
	
	

