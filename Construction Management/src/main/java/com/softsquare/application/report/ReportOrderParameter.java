package com.softsquare.application.report;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;

public class ReportOrderParameter {
    private Integer orderMaterialId;
	private Integer employeeId;
	private String   orderMaterialNo;
	private Date   orderMaterialDate;
	private String  status;
	private String  address;
	private Integer  materialName;
	private String anotation;
	private Integer  quantityOrder;
	private Map<String, String>paramsRpt;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getMaterialName() {
		return materialName;
	}
	public void setMaterialName(Integer materialName) {
		this.materialName = materialName;
	}
	public String getAnotation() {
		return anotation;
	}
	public void setAnotation(String anotation) {
		this.anotation = anotation;
	}
	public Integer getQuantityOrder() {
		return quantityOrder;
	}
	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}
	public Map<String, String> getParamsRpt() {
		return paramsRpt;
	}
	public void setParamsRpt(Map<String, String> paramsRpt) {
		this.paramsRpt = paramsRpt;
	}
	
	
	
}
