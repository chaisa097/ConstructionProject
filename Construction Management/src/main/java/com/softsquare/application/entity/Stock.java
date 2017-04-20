package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable{

	
	private static final long serialVersionUID = -8343915917199444773L;

	@Id
    @GeneratedValue
    @Column(name = "STOCKID")
	private Integer stockId;
	
	@Column(name = "MATERIALID")
	private Integer  materialId;
	
	@Column(name = "TOTAL_QUANTITY")
	private Integer  totalQuatity;
	
	@Column(name = "PRICE")
	private Integer  price;

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MATERIALID", referencedColumnName = "MATERIALID", insertable=false, updatable=false)
    private Material material;


	public Integer getStockId() {
		return stockId;
	}


	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}


	public Integer getMaterialId() {
		return materialId;
	}


	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}


	public Integer getTotalQuatity() {
		return totalQuatity;
	}


	public void setTotalQuatity(Integer totalQuatity) {
		this.totalQuatity = totalQuatity;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	
	
	
	
}
