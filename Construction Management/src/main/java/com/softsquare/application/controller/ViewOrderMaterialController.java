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
import com.softsquare.application.domain.OrderMaterialDetailMapping;
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.service.OrderMaterialDetialService;
import com.softsquare.application.service.OrderMaterialService;
@RestController
@RequestMapping("/viewOrder.html")
@Configurable
public class ViewOrderMaterialController {
	@Autowired
	private OrderMaterialDetialService orderDetailService;
	@Autowired
	private OrderMaterialService orderService;
	
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialDetailMapping mapping ){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("viewOrder");
    	if(BeanUtils.isNotNull(mapping.getOrderMaterialId())){
    		mav.addObject("headerId",mapping.getOrderMaterialId());
    	}
    	return ControllerDefault.DefaultModelAndView(mav, request);
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
	
	@RequestMapping(params =  "method=searchHeader" , method=RequestMethod.POST)
    public void searchHeader(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialMapping order) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(orderService.findOrder(order));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=sendOrder" , method=RequestMethod.POST)
    public void sendAndUpdateStatus(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialMapping order) throws Throwable{
		orderService.updateStatus(order);
	}
}
