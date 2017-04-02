package com.softsquare.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.OrderMaterialMapping;

@RestController
@RequestMapping("/viewOrder.html")
@Configurable
public class ViewOrderMaterialController {
	
	public ModelAndView page(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialMapping mapping ){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("viewOrder");
    	if(BeanUtils.isNotNull(mapping.getOrderMaterialId())){
    		mav.addObject("headerId",mapping.getOrderMaterialId());
    	}
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }

}
