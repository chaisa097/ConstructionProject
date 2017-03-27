package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORKING")
public class Working  implements Serializable {

	private static final long serialVersionUID = 6019490232774665003L;
	
	
	@Id
    @GeneratedValue
    @Column(name = "WORKINGID")
	private Integer workingId;
	
	@Column(name = "EMPLOYEEID", nullable = false)
	private Integer  employeeId;
	
	@Column(name = "PROJECTID", nullable = false)
	private Integer  projectId;
	
	@Column(name = "AMOUNT_MONTH", nullable = false)
	private Integer  amountOfMonth;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID", insertable=false, updatable=false)
    private Employee employee;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECTID", referencedColumnName = "PROJECTID", insertable=false, updatable=false)
    private Project project;
	
	

	public Integer getWorkingId() {
		return workingId;
	}

	public void setWorkingId(Integer workingId) {
		this.workingId = workingId;
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

	public Integer getAmountOfMonth() {
		return amountOfMonth;
	}

	public void setAmountOfMonth(Integer amountOfMonth) {
		this.amountOfMonth = amountOfMonth;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


   
     
	
	
	
	
	
	
	
}
