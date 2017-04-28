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
@Table(name = "EXPORT_MATERIAL")
public class ExportMaterial implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7605416904732366935L;


	@Id
    @GeneratedValue
    @Column(name = "EXPORT_MATERIALID")
	private Integer exportMaterialId;
	

	@Column(name = "EMPLOYEEID", unique=true, nullable = false)
	private Integer  employeeId;
	
	@Column(name = "EXPORT_MATERIALNO", unique=true, nullable = false)
	private String  exportMaterialNo;
	
	@Column(name = "EXPORT_DATE", unique=true, nullable = false)
	private Date    exportDate;
	
	@Column(name = "REQUEST_MATERIALID", unique=true, nullable = false)
	private Integer  requestMaterialId;
	
	@Column(name = "REQUEST_PROJECTID", unique=true, nullable = false)
	private Integer  projectId;

	@Column(name = "STATUS", unique=true, nullable = false)
	private String  status;
	
	@Column(name = "TOTAL_EXPORT", unique=true, nullable = false)
	private Integer  totalExport;

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID", insertable=false, updatable=false)
    private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUEST_PROJECTID", referencedColumnName = "PROJECTID", insertable=false, updatable=false)
    private Project project;
	
	

	public Integer getExportMaterialId() {
		return exportMaterialId;
	}


	public void setExportMaterialId(Integer exportMaterialId) {
		this.exportMaterialId = exportMaterialId;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public String getExportMaterialNo() {
		return exportMaterialNo;
	}


	public void setExportMaterialNo(String exportMaterialNo) {
		this.exportMaterialNo = exportMaterialNo;
	}


	public Date getExportDate() {
		return exportDate;
	}


	public void setExportDate(Date exportDate) {
		this.exportDate = exportDate;
	}


	public Integer getRequestMaterialId() {
		return requestMaterialId;
	}


	public void setRequestMaterialId(Integer requestMaterialId) {
		this.requestMaterialId = requestMaterialId;
	}


	public Integer getProjectId() {
		return projectId;
	}


	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getTotalExport() {
		return totalExport;
	}


	public void setTotalExport(Integer totalExport) {
		this.totalExport = totalExport;
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
