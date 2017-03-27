package com.softsquare.application.domain;

import java.util.Date;

public class EmployeeMapping {
     private Integer employeeId;
     private String  employeeCode;
     private String  empFirstName;
     private String  empLastName;
     private String  citizenId;
     private String  province;
     private String  subDistrict;
     private String  district;
     private Date    birthDay;
     private Date   statsHireDate;
     private Integer departmentDetailId;
     private String  departmentDetail;
     
     
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getSubDistrict() {
		return subDistrict;
	}
	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Date getStatsHireDate() {
		return statsHireDate;
	}
	public void setStatsHireDate(Date statsHireDate) {
		this.statsHireDate = statsHireDate;
	}
	public Integer getDepartmentDetailId() {
		return departmentDetailId;
	}
	public void setDepartmentDetailId(Integer departmentDetailId) {
		this.departmentDetailId = departmentDetailId;
	}
	public String getDepartmentDetail() {
		return departmentDetail;
	}
	public void setDepartmentDetail(String departmentDetail) {
		this.departmentDetail = departmentDetail;
	}
     
     
	
     
     
     
     
     
     
}
