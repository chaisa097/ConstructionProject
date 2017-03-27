package com.softsquare.application.domain;

import java.util.Date;

import com.softsquare.application.entity.Employee;

public class OrderMaterialMapping {
	
	private Integer orderMaterialId;
	private Integer employeeId;
	private String  orderMaterialNo;
	private Date    orderMaterialDate;
	private String  status;
	private String  employee;
	
	
	public Integer getOrderMaterialId() {
		return orderMaterialId;
	}
	public void setOrderMaterialId(Integer orderMaterialId) {
		this.orderMaterialId = orderMaterialId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getOrderMaterialNo() {
		return orderMaterialNo;
	}
	public void setOrderMaterialNo(String orderMaterialNo) {
		this.orderMaterialNo = orderMaterialNo;
	}
	public Date getOrderMaterialDate() {
		return orderMaterialDate;
	}
	public void setOrderMaterialDate(Date orderMaterialDate) {
		this.orderMaterialDate = orderMaterialDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}

	
	
	
	
}
