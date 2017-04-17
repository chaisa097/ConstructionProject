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
@Table(name = "REQUEST_MATERIAL")
public class RequestMaterial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4248815255304296082L;
	
	@Id
    @GeneratedValue
    @Column(name = "REQUEST_MATERIALID")
	private Integer   requestMaterialId;
	

	@Column(name = "EMPLOYEEID", unique=true, nullable = false)
	private Integer  employeeId;
	
	@Column(name = "PROJECTID", unique=true, nullable = false)
	private Integer  projectId;
	
	@Column(name = "REQUEST_MATERIALNO", unique=true, nullable = false)
	private String  requestMaterialNo;
	
	@Column(name = "REQUEST_DATE", unique=true, nullable = false)
	private Date    requestDate;
	
	@Column(name = "CONTACT_OWNER", unique=true, nullable = false)
	private String  contactOwner;
	
	@Column(name = "STATUS", unique=true, nullable = false)
	private String  status;
	
	@Column(name = "USE_MATERIALDATE", unique=true, nullable = false)
	private Date    useMaterialDate;
	
	
     
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID", insertable=false, updatable=false)
    private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECTID", referencedColumnName = "PROJECTID", insertable=false, updatable=false)
    private Project project;

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



	public Date getRequestDate() {
		return requestDate;
	}



	public void setRequestDate(Date requestDate) {
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



	public Date getUseMaterialDate() {
		return useMaterialDate;
	}



	public void setUseMaterialDate(Date useMaterialDate) {
		this.useMaterialDate = useMaterialDate;
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
