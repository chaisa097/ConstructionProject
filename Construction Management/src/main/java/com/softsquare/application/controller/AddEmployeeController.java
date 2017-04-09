package com.softsquare.application.controller;

import java.util.ArrayList;

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
@RequestMapping("/addEmployee.html")
@Configurable
public class AddEmployeeController {

	@Autowired
	WorkingService workingSevice;
	
	@Autowired
	ProjectService listprojectSevice;
	
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response, @ModelAttribute WorkingMapping mapping){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("addEmployee");
    	if (BeanUtils.isNotNull(mapping.getProjectId())){
            mav.addObject("headerId",mapping.getProjectId());
            
      	}
    	
	return ControllerDefault.DefaultModelAndView(mav, request);
}
	
	@RequestMapping(params =  "method=save" , method=RequestMethod.POST)
    public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute WorkingMapping mapping) throws Throwable{
		workingSevice.save(mapping);
		
	
         
	}
	
	@RequestMapping(params =  "method=delete" , method=RequestMethod.POST)
    public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute WorkingMapping mapping) throws Throwable{
		workingSevice.removeWorker(mapping);
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
	

	@RequestMapping(params =  "method=UpdateTotalSalary" , method=RequestMethod.POST)
    public void updateProject(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ProjectMapping project) throws Throwable{
		workingSevice.updatetotalHireEmployee(project);
	}
	
	
	
	
}
