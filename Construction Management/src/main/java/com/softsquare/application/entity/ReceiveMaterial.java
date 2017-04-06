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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "RECEIVE_MATERIAL")
public class ReceiveMaterial implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9169240983344346689L;

	@Id
    @GeneratedValue
    @Column(name = "RECEIVE_MATERIALID")
	private Integer receiveMaterialId;
	

	@Column(name = "EMPLOYEEID", unique=true, nullable = false)
	private Integer  employeeId;
	
	@Column(name = "RECEIVE_MATERIALNO", unique=true, nullable = false)
	private String  receiveMaterialNo;
	
	@Column(name = "RECEIVE_DATE", unique=true, nullable = false)
	private Date    receiveDate;
	
	@Column(name = "ORDER_MATERIALID", unique=true, nullable = false)
	private Integer  orderMaterialId;
     
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID", insertable=false, updatable=false)
    private Employee employee;




	public Integer getReceiveMaterialId() {
		return receiveMaterialId;
	}

	public void setReceiveMaterialId(Integer receiveMaterialId) {
		this.receiveMaterialId = receiveMaterialId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getReceiveMaterialNo() {
		return receiveMaterialNo;
	}

	public void setReceiveMaterialNo(String receiveMaterialNo) {
		this.receiveMaterialNo = receiveMaterialNo;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getOrderMaterialId() {
		return orderMaterialId;
	}

	public void setOrderMaterialId(Integer orderMaterialId) {
		this.orderMaterialId = orderMaterialId;
	}

	
	
	
	

}
