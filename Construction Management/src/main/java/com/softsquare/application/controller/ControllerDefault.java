package com.softsquare.application.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.common.util.LoginUtils;

@Component
public class ControllerDefault {
	
	
	public static  ModelAndView DefaultModelAndView(ModelAndView mav, HttpServletRequest httpServletRequest){
		Properties prop = new Properties();
		InputStream input = null;
		String domainName = null;
    
		final String[] roleAll = new String[]{"admin","pm","eng","st"};
		final String[] pageAdmin = new String[]{"home","addEmployee", "registerList","projectHistory" ,"register", "manageRole","province","createProject","listproject","viewProject","viewEmployee","department","departmentdetail","employeeList","createEmployee","type","unit","material"};
		final String[] pageProjectManager = new String[]{"home","listPojectPM","addEmployee","viewProject","stock","editStatusProject","listRequestMaterialPM","confirmRequestMaterial","listExportMaterial","viewExportMaterialPM"};
		final String[] pageEngineer = new String[]{"importMaterial","stock","orderMaterial","orderMaterialDetail","viewOrder","listOrder","createRequestMaterial","requestMaterialDetail","viewRequestMaterial","listRequestMaterial","listExportMaterialEngineer","viewExportMaterial","exportMaterialConfirm","type","unit","material"};
		final String[] pageStocker = new String[]{"stock","receiveMaterial","addMaterialStock","requestMaterialStock","exportMaterial","confirmOrder","orderMaterial","orderMaterialDetail","viewOrder","listOrder","listOrderPM"};
		final String[] pageNoLogin = new String[]{"index", "pageTest"};
		int count = 0;
		
		
		if(BeanUtils.isNotEmpty(mav.getViewName())){
			if("logoutpage".equals(mav.getViewName())){
				mav.setViewName("index");
				mav.addObject("userNameUserSystem", "");
				mav.addObject("roleUserSystem", "");
			}else{
				// check Use can view page 
				if(BeanUtils.isNotEmpty(LoginUtils.getRole()) && BeanUtils.isNotEmpty(LoginUtils.getUsername())){
					try{
						//Strat Condition zone add page of role
						if(roleAll[0].equals(LoginUtils.getRole())){ //Admin
							for (String string : pageAdmin) {
								if(string.equals(mav.getViewName())){
									count = 1;
								}
							}
						}else if(roleAll[1].equals(LoginUtils.getRole())){ //ProjectManager
							for (String string : pageProjectManager) {
								if(string.equals(mav.getViewName())){
									count = 1;
								}
							}
																					
						}else if(roleAll[2].equals(LoginUtils.getRole())){ //Engineer
							for (String string : pageEngineer) {
								if(string.equals(mav.getViewName())){
									count = 1;
								}
							}
						}else if(roleAll[3].equals(LoginUtils.getRole())){ //Stocker 
						
							for (String string : pageStocker) {
								if(string.equals(mav.getViewName())){
									count = 1;
								}
							}							
						}else{
							throw new Exception();
						}
						//End Condition zone add page of role
						
						if(count == 0){
							for (String string : pageNoLogin) {
								if(string.equals(mav.getViewName())){
									count = 1;
								}
							}
						}
						
						if(count == 0){
							throw new Exception();
						}
						
					
					
						
						
						mav.addObject("userNameUserSystem", LoginUtils.getUsername());
						mav.addObject("roleUserSystem", LoginUtils.getRole());
						
					} catch(Exception ex){
						mav.addObject("userNameUserSystem", LoginUtils.getUsername());
						mav.addObject("roleUserSystem", LoginUtils.getRole());
						
						    mav.setViewName("home");
					    }
					
				}else{
					try{
						for (String string : pageNoLogin) {
							if(string.equals(mav.getViewName())){
								count = 1;
							}
						}
						if(count == 0){
							throw new Exception(); 
						}
					}catch(Exception ex){
						mav.setViewName("index");
					}
				}
			}
		}
		
		try {
			input = new FileInputStream("src/main/resources/application.properties");
			prop.load(input);
			domainName = prop.getProperty("server.contextPath");
		} catch (Exception e) {
			System.out.println("Load file application.properties not found.");
		}
		
		try {
			mav.addObject("nameDomainSystem", domainName);
			mav.addObject("ipDomainSystem", InetAddress.getLocalHost().getHostAddress()+":"+httpServletRequest.getServerPort());
		} catch (Exception e) {
			mav.addObject("nameDomainSystem", domainName);
			mav.addObject("ipDomainSystem", "http://127.0.0.1:"+httpServletRequest.getServerPort());
		}
		
		return mav;
	}
}
