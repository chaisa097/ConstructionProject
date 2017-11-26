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
import com.softsquare.application.domain.RequestMaterialDetailMapping;
import com.softsquare.application.domain.RequestMaterialMapping;
import com.softsquare.application.report.JasperGenerateReport;
import com.softsquare.application.service.RequestMaterialDetailService;
import com.softsquare.application.service.RequestMaterialService;

@RestController
@RequestMapping("/confirmRequestMaterial.html")
@Configurable
public class ConfirmRequestMaterialController {

	 @Autowired
    private JasperGenerateReport jasperGenerateReport;
	@Autowired
	RequestMaterialDetailService requestDetailService;
	@Autowired
	RequestMaterialService  reqMaterialServ;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView page(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialDetailMapping mapping ){
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("confirmRequestMaterial");
    	if(BeanUtils.isNotNull(mapping.getRequestMaterialId())){
    		mav.addObject("headerId",mapping.getRequestMaterialId());
    	}
    	return ControllerDefault.DefaultModelAndView(mav, request);
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
	
	@RequestMapping(params =  "method=searchHeader" , method=RequestMethod.POST) 
    public void searchHeader(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialMapping Mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(reqMaterialServ.FindRequestMaterial(Mapping));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=confirmRequest" , method=RequestMethod.POST)
    public void sendAndUpdateStatus(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialMapping Mapping) throws Throwable{
		reqMaterialServ.updateStatusConfirmed(Mapping);
	}
	
	
	@RequestMapping(params =  "method=RejectRequest" , method=RequestMethod.POST)
    public void sendAndUpdateStatusReject(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialMapping Mapping) throws Throwable{
		reqMaterialServ.updateStatusReject(Mapping);
	}
	
	@RequestMapping(params =  "method=searchProjectId", method=RequestMethod.POST)
    public void searchProjectbyRequestMaterialId(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RequestMaterialDetailMapping mapping) throws Throwable{
		Gson gson = new Gson();
		String  json = gson.toJson(requestDetailService.findMaterialDetailByRequestMaterialId(mapping.getRequestMaterialId()));
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/reportGen.html", method=RequestMethod.GET)
    public void report01Generate(@RequestParam("reportParameter") String reportParameter, HttpServletRequest request, HttpServletResponse response){
		try {
			jasperGenerateReport.generateMainReport(reportParameter, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
