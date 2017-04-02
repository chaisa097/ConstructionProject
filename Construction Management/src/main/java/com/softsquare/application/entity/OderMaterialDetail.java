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
@Table(name = "ORDER_MATERIALDETAIL")
public class OderMaterialDetail  implements Serializable {

	
	private static final long serialVersionUID = -117259679410559094L;

	@Id
    @GeneratedValue
    @Column(name = "ORDER_MATERIALDETAIID")
	private Integer orderMaterialDatailId;
	
	
	@Column(name = "ORDER_MATERIALID", nullable = false)
	private Integer orderMaterialId;
	
	@Column(name = "MATERIALID", nullable = false)
	private Integer   materialId;
	
	@Column(name = "ANOTATION", nullable = false)
	private String anotation;
	
	@Column(name = "QUANTITY_ORDER", nullable = false)
	private Integer  quantityOrder;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIALID", referencedColumnName = "MATERIALID", insertable=false, updatable=false)
    private Material  material;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_MATERIALID", referencedColumnName = "ORDER_MATERIALID", insertable=false, updatable=false)
    private OrderMaterial order;
	
	
	public Integer getOrderMaterialDatailId() {
		return orderMaterialDatailId;
	}

	public void setOrderMaterialDatailId(Integer orderMaterialDatailId) {
		this.orderMaterialDatailId = orderMaterialDatailId;
	}

	public Integer getOrderMaterialId() {
		return orderMaterialId;
	}

	public void setOrderMaterialId(Integer orderMaterialId) {
		this.orderMaterialId = orderMaterialId;
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
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

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public OrderMaterial getOrder() {
		return order;
	}

	public void setOrder(OrderMaterial order) {
		this.order = order;
	}
	
	
	
}
