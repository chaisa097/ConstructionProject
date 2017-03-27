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
@Table(name = "PROJECT")
public class Project extends BaseEntity  implements Serializable{
	
	private static final long serialVersionUID = 6019490232774665003L;

	@Id
    @GeneratedValue
    @Column(name = "PROJECTID")
	private Integer projectId;
	
	
	@Column(name = "PROJECTNAME",unique=true, nullable = false)
	private String  projectName;
	
	@Column(name = "DESCRIPTION", nullable = false)
	private String  description;
	
	@Column(name = "PROVINCEID", nullable = false)
	private Integer  provinceId;
	
	@Column(name = "ADDRESS", nullable = false)
	private String  address;
	
	@Column(name = "START_DATE", nullable = false)
	private Date  startDate;

	@Column(name = "FINISH_DATE", nullable = false)
	private Date  finishDate;

	@Column(name = "CUSTOMER_NAME", nullable = false)
	private String customerName;
	
	@Column(name = "CUSTOMER_PHONE", nullable = false)
	private String  customerPhone;
	
	@Column(name = "EMPLOYEEID", nullable = false)
	private Integer  employeeId;
	
	@Column(name = "BUDGET", nullable = false)
	private Integer  budget;
	
	@Column(name = "CRITICAL_BUDGET", nullable = false)
	private Integer criticalBudget;
	
	@Column(name = "TOTAL_HIRE_EMPLOYEE", nullable = false)
	private Integer totalHireEmployee;
	
	@Column(name = "TOTAL_USE_MATERIAL", nullable = false)
	private Integer totalUseMaterial;
	
	@Column(name = "TOTAL_EXPENSE", nullable = false)
	private Integer totalExpense;
	
	@Column(name = "PERCENT_STATUS", nullable = false)
	private Integer percentStatus; 
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID", insertable=false, updatable=false)
    private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCEID", referencedColumnName = "PROVINCEID", insertable=false, updatable=false)
    private Province province;
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}


	public Integer getTotalHireEmployee() {
		return totalHireEmployee;
	}

	public void setTotalHireEmployee(Integer totalHireEmployee) {
		this.totalHireEmployee = totalHireEmployee;
	}

	public Integer getTotalUseMaterial() {
		return totalUseMaterial;
	}

	public void setTotalUseMaterial(Integer totalUseMaterial) {
		this.totalUseMaterial = totalUseMaterial;
	}

	public Integer getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(Integer totalExpense) {
		this.totalExpense = totalExpense;
	}	
	
	public Integer getPercentStatus() {
		return percentStatus;
	}

	public void setPercentStatus(Integer percentStatus) {
		this.percentStatus = percentStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Integer getCriticalBudget() {
		return criticalBudget;
	}

	public void setCriticalBudget(Integer criticalBudget) {
		this.criticalBudget = criticalBudget;
	}
	
	
	
	
}
