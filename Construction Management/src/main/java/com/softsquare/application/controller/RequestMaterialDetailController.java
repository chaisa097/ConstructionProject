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
import com.softsquare.application.domain.MaterialMapping;
import com.softsquare.application.domain.OrderMaterialDetailMapping;
import com.softsquare.application.domain.RequestMaterialDetailMapping;
import com.softsquare.application.domain.StockMapping;
import com.softsquare.application.service.RequestMaterialDetailService;
import com.softsquare.application.service.StockService;


@RestController
@RequestMapping("/requestMaterialDetail.html")
@Configurable
public class RequestMaterialDetailController {

	@Autowired
	RequestMaterialDetailService requestDetailService;
	
	@Autowired
	 private  StockService stockServ;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialDetailMapping mapping){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("requestMaterialDetail");
    	if(BeanUtils.isNotNull(mapping.getRequestMaterialId())){
    		mav.addObject("headerId",mapping.getRequestMaterialId());
    	}
    	return ControllerDefault.DefaultModelAndView(mav, request);
    }

	@RequestMapping(params =  "method=save" , method=RequestMethod.POST)
    public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialDetailMapping mapping) throws Throwable{
		requestDetailService.saveRequestDetail(mapping);
         
	}
	
	@RequestMapping(params =  "method=search" , method=RequestMethod.POST)
    public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialDetailMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(requestDetailService.ListRequestDetail(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=materialstock" , method=RequestMethod.POST)
    public void searchMaterialStockQuality(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(stockServ.findMaterialQuatityFormStockbyMaterialId(mapping.getMaterialId()));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	
	
	@RequestMapping(params ="method=delete" , method=RequestMethod.POST)
	public void delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialDetailMapping mapping) throws Throwable{
		requestDetailService.removeRequestDetail(mapping);
	}
	
	@RequestMapping(params =  "method=searchQuatityInstock", method=RequestMethod.POST)
    public void searchMaterial(HttpServletRequest request, HttpServletResponse response, @ModelAttribute StockMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(stockServ.getMaterialinStock(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
}
