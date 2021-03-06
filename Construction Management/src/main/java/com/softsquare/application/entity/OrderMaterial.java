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
@Table(name = "ORDER_MATERIAL")
public class OrderMaterial implements Serializable  {
	
	private static final long serialVersionUID = 6019490232774665003L;

	@Id
    @GeneratedValue
    @Column(name = "ORDER_MATERIALID")
	private Integer orderMaterialId;
	

	@Column(name = "EMPLOYEEID", nullable = false)
	private Integer employeeId;

	
	@Column(name = "ORDERMARERIAL_NO")
	private String   orderMaterialNo;
	
	@Column(name = "ORDERMARERIAL_DATE", nullable = false)
	private Date   orderMaterialDate;
	
	@Column(name = "STATUS", nullable = false)
	private String  status;
	
	@Column(name = "ADDRESS", nullable = false)
	private String  address;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID", insertable=false, updatable=false)
    private Employee employee;
	
	
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	

}
