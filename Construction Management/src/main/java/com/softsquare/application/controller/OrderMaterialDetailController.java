package com.softsquare.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.LoginMapping;
import com.softsquare.application.domain.OrderMaterialDetailMapping;
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.domain.ProjectMapping;
import com.softsquare.application.service.OrderMaterialDetialService;



@RestController
@RequestMapping("/orderMaterialDetail.html")
@Configurable
public class OrderMaterialDetailController {
	
	@Autowired
	private OrderMaterialDetialService orderDetailService;

	
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialDetailMapping mapping ){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("orderMaterialDetail");
    	if(BeanUtils.isNotNull(mapping.getOrderMaterialId())){
    		mav.addObject("headerId",mapping.getOrderMaterialId());
    	}
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }
	@RequestMapping(params = "method=save" , method=RequestMethod.POST)
	public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialDetailMapping mapping) throws Throwable{
		orderDetailService.saveOrdermaterialDetail(mapping);
		
	}
	
	@RequestMapping(params ="method=delete" , method=RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialDetailMapping mapping) throws Throwable{
		orderDetailService.removeOrderMaterial(mapping);
	}
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
    public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialDetailMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(orderDetailService.getOrderMaterialDetail(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}


}
