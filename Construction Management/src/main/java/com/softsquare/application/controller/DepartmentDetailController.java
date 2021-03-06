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
import com.softsquare.application.domain.DepartmentDetailMapping;
import com.softsquare.application.domain.DepartmentMapping;
import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.service.DepartmentDetailService;
import com.softsquare.application.service.DepartmentService;
import com.softsquare.application.service.ProvinceService;

@RestController
@RequestMapping("/departmentdetail.html")
@Configurable
public class DepartmentDetailController {

@Autowired
DepartmentDetailService depDetailService;
	

		@RequestMapping(method=RequestMethod.GET)
		    public ModelAndView page(HttpServletRequest request, HttpServletResponse response){
		    	ModelAndView mav = new ModelAndView();
		    	mav.setViewName("departmentdetail");
			return ControllerDefault.DefaultModelAndView(mav, request);
		}
	
		@RequestMapping(params =  "method=save" , method=RequestMethod.POST)
	    public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DepartmentDetailMapping mapping) throws Throwable{
			depDetailService.saveDepartmentDetail(mapping);
		
	         
		}
		
		@RequestMapping(params =  "method=edit" , method=RequestMethod.POST)
	    public void edit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DepartmentDetailMapping mapping) throws Throwable{
			depDetailService.updateDepartmentDetail(mapping);
		}
		
		@RequestMapping(params =  "method=delete" , method=RequestMethod.POST)
	    public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DepartmentDetailMapping mapping) throws Throwable{
			depDetailService.removeDepartmentDetail(mapping);
		}
		
		@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
		public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DepartmentDetailMapping mapping) throws Throwable{
			Gson gson = new Gson();
			String  json = gson.toJson(depDetailService.getDepartmentDetail());
//			System.out.print(json);
			try {
				response.getWriter().write(json);
			} catch (Exception e) {
					e.printStackTrace();
			}
	
			
		}
		
		@RequestMapping(params =  "method=searchDepartmentforUpdate" , method=RequestMethod.POST)
		public void searchDepartmentforUpdate(HttpServletRequest request, HttpServletResponse response, @ModelAttribute DepartmentDetailMapping mapping) throws Throwable{
			Gson gson = new Gson();
			String  json = gson.toJson(depDetailService.findDepartmentDetail(mapping));
//			System.out.print(json);
			try {
				response.getWriter().write(json);
			} catch (Exception e) {
					e.printStackTrace();
			}
	
			
		}
		
		
		}	

