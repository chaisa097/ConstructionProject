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
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.entity.Employee;
import com.softsquare.application.service.EmployeeService;
import com.softsquare.application.service.ProjectService;

@RestController
@RequestMapping("/home.html")
@Configurable
public class HomeController {
	@Autowired
	ProjectService  proServ;
	@Autowired
	EmployeeService EmpServ;
	
	  @RequestMapping(method=RequestMethod.GET)
	    public ModelAndView home(HttpServletRequest httpServletRequest){
	    	ModelAndView mav = new ModelAndView();
	    	mav.setViewName("home");
	    	return ControllerDefault.DefaultModelAndView(mav, httpServletRequest);
	    }
	
	  
	 @RequestMapping(params = "method=search", method=RequestMethod.POST)
     public void countProject(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ProjectMapping mapping) throws Throwable{
			Gson gson = new Gson();	
			
			String  json = gson.toJson(proServ.countProject());
			System.out.println(json);

			try {
				response.getWriter().write(json);
			} catch (Exception e) {
					e.printStackTrace();
			}

			
		}
	 
	 @RequestMapping(params = "method=searchEmployee", method=RequestMethod.POST)
     public void countEmployee(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ProjectMapping mapping) throws Throwable{
			Gson gson = new Gson();	
			
			String  json = gson.toJson(EmpServ.CountEmployee());
			System.out.println(json);

			try {
				response.getWriter().write(json);
			} catch (Exception e) {
					e.printStackTrace();
			}

			
		}
	  
	 
	 
	  
	  
	  
	
}
