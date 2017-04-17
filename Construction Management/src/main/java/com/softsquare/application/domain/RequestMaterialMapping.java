package com.softsquare.application.domain;

import com.softsquare.application.entity.Employee;

public class RequestMaterialMapping {

	private Integer   requestMaterialId;
	private Integer   employeeId;
	private Integer   projectId;
	private String    requestMaterialNo;
	private String    requestDate;
	private String    contactOwner;
	private String    status;
	private String    useMaterialDate;
	private Employee  employee;
	
	public Integer getRequestMaterialId() {
		return requestMaterialId;
	}
	public void setRequestMaterialId(Integer requestMaterialId) {
		this.requestMaterialId = requestMaterialId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	public String getRequestMaterialNo() {
		return requestMaterialNo;
	}
	public void setRequestMaterialNo(String requestMaterialNo) {
		this.requestMaterialNo = requestMaterialNo;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getContactOwner() {
		return contactOwner;
	}
	public void setContactOwner(String contactOwner) {
		this.contactOwner = contactOwner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUseMaterialDate() {
		return useMaterialDate;
	}
	public void setUseMaterialDate(String useMaterialDate) {
		this.useMaterialDate = useMaterialDate;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
