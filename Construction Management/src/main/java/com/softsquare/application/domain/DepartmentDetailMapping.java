package com.softsquare.application.domain;

public class DepartmentDetailMapping {
	
	private Integer depDetailId;
	private String  depDetailName;
	 private Integer departmentId;
	 private Integer Salary;
	 
	public Integer getDepDetailId() {
		return depDetailId;
	}
	public void setDepDetailId(Integer depDetailId) {
		this.depDetailId = depDetailId;
	}
	public String getDepDetailName() {
		return depDetailName;
	}
	public void setDepDetailName(String depDetailName) {
		this.depDetailName = depDetailName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getSalary() {
		return Salary;
	}
	public void setSalary(Integer salary) {
		Salary = salary;
	}

}
