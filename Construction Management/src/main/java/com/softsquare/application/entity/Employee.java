package com.softsquare.application.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	
	private static final long serialVersionUID = 6019490232774665003L;

	@Id
    @GeneratedValue
    @Column(name = "EMPLOYEEID")
	private Integer employeeId;
	
	@Column(name = "EMPLOYEE_CODE")
	private String  employeeCode;
	
	@Column(name = "EMPLOYEE_FIRSTNAME")
	private String  empFirstName;
	
	@Column(name = "EMPLOYEE_LASTNAME")
	private String  empLastName;
	
	@Column(name = "CITIZENID")
	private String  citizenId;

	@Column(name = "PROVINCE")
	private String  province;
	
	@Column(name = "DISTRICT")
	private String  district;
	
	@Column(name = "SUB_DISTRICT")
	private String  subDistrict;
	
	@Column(name = "BIRTHDAY")
	private Date  birthDay;
	
	@Column(name = "STATS_HIRE_DATE")
	private Date  statsHireDate;
	
	@Column(name = "DEPARTMENTDETAIL_ID")
	private Integer  departmentDetailId;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENTDETAIL_ID", referencedColumnName = "DEPARTMENTDETAILID", insertable=false, updatable=false)
    private DepartmentDetail departmentDetail;
	
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSubDistrict() {
		return subDistrict;
	}

	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
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

	public DepartmentDetail getDepartmentDetail() {
		return departmentDetail;
	}

	public void setDepartmentDetail(DepartmentDetail departmentDetail) {
		this.departmentDetail = departmentDetail;
	}
	
	



	
}
