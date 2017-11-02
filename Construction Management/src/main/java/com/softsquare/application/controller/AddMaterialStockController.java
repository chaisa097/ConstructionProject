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
import com.softsquare.application.domain.OrderMaterialMapping;
import com.softsquare.application.domain.ReceiveMaterialMapping;
import com.softsquare.application.domain.StockMapping;
import com.softsquare.application.service.MaterialService;
import com.softsquare.application.service.OrderMaterialDetialService;
import com.softsquare.application.service.OrderMaterialService;
import com.softsquare.application.service.ReceiveMaterialService;
import com.softsquare.application.service.StockService;
import com.softsquare.application.service.ReceiveMaterialDetailService;
@RestController
@RequestMapping("/AddMaterialStock.html")
@Configurable
public class AddMaterialStockController {

	@Autowired
	private OrderMaterialDetialService orderDetailService;
	@Autowired
	private OrderMaterialService orderService;
	@Autowired
	private ReceiveMaterialService receiveService;
	@Autowired
	 private  ReceiveMaterialDetailService reDetailServ;
	@Autowired
	 private  MaterialService materialServ;
	@Autowired           
	private StockService stockServ;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response ,ReceiveMaterialMapping mapping){		
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("addMaterialStock");
    	if(BeanUtils.isNotNull(mapping.getOrderMaterialId())){
    		mav.addObject("headerId",mapping.getOrderMaterialId());
    	}
	return ControllerDefault.DefaultModelAndView(mav, request);
}
	@RequestMapping(params =  "method=searchOrder", method=RequestMethod.POST)
    public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialDetailMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(orderDetailService.getOrderMaterialDetail(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=searchReceiveMaterial", method=RequestMethod.POST)
    public void searchReceiveMaterial(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ReceiveMaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(reDetailServ.ReceiveMaterialDetail(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=searchMaterial", method=RequestMethod.POST)
    public void searchMaterial(HttpServletRequest request, HttpServletResponse response, @ModelAttribute MaterialMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(materialServ.findMaterial(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=searchPrice", method=RequestMethod.POST)
    public void searchPriceMaterial(HttpServletRequest request, HttpServletResponse response, @ModelAttribute StockMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(stockServ.findMaterialPriceFormStock(mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	@RequestMapping(params = "method=save" , method=RequestMethod.POST)
    public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ReceiveMaterialMapping mapping) throws Throwable{
	    receiveService.saveReceive(mapping);
	}
	
	
	
	@RequestMapping(params =  "method=finishOrder" , method=RequestMethod.POST)
    public void confirmOrder(HttpServletRequest request, HttpServletResponse response, @ModelAttribute OrderMaterialMapping order) throws Throwable{
		orderService.updateStatusFinished(order);
	}
	
}
	

