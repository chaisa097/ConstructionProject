package com.softsquare.application.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.softsquare.application.entity.Employee;
import com.softsquare.application.entity.Material;
import com.softsquare.application.entity.MaterialType;
import com.softsquare.application.entity.Province;
import com.softsquare.application.entity.Role;
import com.softsquare.application.service.EmployeeService;
import com.softsquare.application.service.MaterialService;
import com.softsquare.application.service.RoleService;
import com.softsquare.application.service.ProvinceService;
import com.softsquare.application.service.TypeService;


@RestController
@RequestMapping("/combobox.html")
@Configurable
public class ComboboxController {
	
	@Autowired
	private RoleService roleSerivce;
	@Autowired
	private EmployeeService employeeSerivce;
	@Autowired
	private ProvinceService provinceSerivce;

	@Autowired
	private TypeService typeSerivce;
	@Autowired
	private MaterialService materialService;
	
	
	@RequestMapping(params =  "method=role" , method=RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response){
		ArrayList<Role> roleList =  roleSerivce.getRole();
		Gson gson = new Gson();
		String  json = gson.toJson(roleList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	@RequestMapping(params =  "method=employee" , method=RequestMethod.GET)
    public void AddEmployee(HttpServletRequest request, HttpServletResponse response  ){
		ArrayList<Employee> employeeList =  employeeSerivce.getEmployee();
		Gson gson = new Gson();
		String  json = gson.toJson(employeeList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=Allemployee" , method=RequestMethod.GET)
    public void registerAllEmployee(HttpServletRequest request, HttpServletResponse response  ){
		ArrayList<Employee> employeeList =  employeeSerivce.getAllEmployee();
		Gson gson = new Gson();
		String  json = gson.toJson(employeeList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	

	@RequestMapping(params =  "method=projectManger" , method=RequestMethod.GET)
    public void projectManagerlist(HttpServletRequest request, HttpServletResponse response  ){
		ArrayList<Employee> employeeList =  employeeSerivce.getProjectManager();
		Gson gson = new Gson();
		String  json = gson.toJson(employeeList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	@RequestMapping(params =  "method=Type" , method=RequestMethod.GET)
    public void typeMateriallist(HttpServletRequest request, HttpServletResponse response  ){
		ArrayList<MaterialType> typeList =  typeSerivce.getMaterialType();
		Gson gson = new Gson();
		String  json = gson.toJson(typeList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	@RequestMapping(params =  "method=Material" , method=RequestMethod.GET)
    public void Materiallist(@RequestParam("TypeId") int typeId,HttpServletRequest request, HttpServletResponse response  ){
		ArrayList<Material> materialList =  materialService.getMaterial(typeId);		
		Gson gson = new Gson();
		String  json = gson.toJson(materialList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	
	@RequestMapping(params =  "method=Allmaterial" , method=RequestMethod.GET)
    public void Materialcombobox(HttpServletRequest request, HttpServletResponse response  ){
		ArrayList<Material> materialList =  materialService.AllMaterial();		
		Gson gson = new Gson();
		String  json = gson.toJson(materialList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	@RequestMapping(params =  "method=province" , method=RequestMethod.GET)
    public void listProvince(HttpServletRequest request, HttpServletResponse response  ){
		ArrayList<Province> provinceList =  provinceSerivce.getProvince();
		Gson gson = new Gson();
		String  json = gson.toJson(provinceList);
		try {
//			response.getWriter().write("{records:"+json+"}");
			response.getWriter().write(json);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	
	
//	@RequestMapping(params =  "method=period" , method=RequestMethod.POST)
//    public void period(@ModelAttribute PeriodMapping periodMapping, HttpServletRequest request, HttpServletResponse response){
//		try {
//			Gson gson = new Gson();
//			ArrayList<Period> periodList =  periodService.findPeriod(periodMapping);
//			Integer totalRecord = periodService.findPeriodPagingTotalRecord(periodMapping);
//			ArrayList<ComboBoxMapping> comboBoxMapping = new ArrayList<ComboBoxMapping>();
//			for (Period period : periodList) {
//				ComboBoxMapping boxMapping = new ComboBoxMapping();
//				boxMapping.setValueField(period.getHyPeriodId().toString());
//				boxMapping.setDisplayField(period.getHyPeriodName());
//				boxMapping.setDescriptionField(DateUtils.formatShortDate(period.getHyPeriodDate()));
//				boxMapping.setValueBigDecimal1(period.getHyPeriodPrice2());
//				boxMapping.setValueBigDecimal2(period.getHyPeriodPrice3());
//				comboBoxMapping.add(boxMapping);
//			}
//			String  json = gson.toJson(comboBoxMapping);
//			response.getWriter().write("{records:"+json+", total:"+totalRecord+"}");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@RequestMapping(params =  "method=period2" , method=RequestMethod.POST)
//    public void search(HttpServletRequest request, HttpServletResponse response, @ModelAttribute PeriodMapping periodMapping) throws Throwable{
//	 Gson gson = new Gson();
//	 String  json = gson.toJson(periodService.findPeriod(periodMapping));
//	 response.getWriter().write("{records:"+json+"}");
//	}
//	
//	@RequestMapping(params =  "method=orderList" , method=RequestMethod.POST)
//    public void orderList(@ModelAttribute OrderHeaderMapping orderHeaderMapping, HttpServletRequest request, HttpServletResponse response){
//		try {
//			 Gson gson = new Gson();
//			 String  json = gson.toJson(orderHeaderService.search(orderHeaderMapping));
//			 Integer totalRecord = orderHeaderService.pagingTotalRecord(orderHeaderMapping);
//			response.getWriter().write("{records:"+json+", total:"+totalRecord+"}");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
}
