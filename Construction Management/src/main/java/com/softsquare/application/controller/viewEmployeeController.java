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
import com.softsquare.application.domain.EmployeeMapping;
import com.softsquare.application.service.EmployeeService;

@RestController
@RequestMapping("/viewEmployee.html")
@Configurable
class viewEmployeeController {

	@Autowired
	EmployeeService employeeSevice;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response,@ModelAttribute EmployeeMapping mapping){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("viewEmployee");
    	if (BeanUtils.isNotNull(mapping.getEmployeeId())){
            mav.addObject("headerId",mapping.getEmployeeId());
      	}
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
    public void SeachProject(HttpServletRequest request, HttpServletResponse response, @ModelAttribute EmployeeMapping mapping) throws Throwable{
	Gson gson = new Gson();	
		
		String  json = gson.toJson(employeeSevice.findEmployeeByIdForView(mapping) );

		 try {
			response.getWriter().write(json);
		 } catch (Exception e) {
				e.printStackTrace();
		 }

		
	 }
	
}
