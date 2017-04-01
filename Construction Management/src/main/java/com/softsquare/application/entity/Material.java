package com.softsquare.application.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAL")
public class Material implements Serializable {


	private static final long serialVersionUID = 6019490232774665003L;
	
	@Id
    @GeneratedValue
    @Column(name = "MATERIALID")
	private Integer materialId;
	

	@Column(name = "MATERIALCODE", nullable = false)
	private String  materialCode;
	
	@Column(name = "MATERIALNAME", nullable = false)
	private String  materialName;
	
	@Column(name = "DESCRITION", nullable = false)
	private String  descrition;
	
	@Column(name = "PRICE", nullable = false)
	private Integer  price;
	
	@Column(name = "TYPEID", nullable = false)
	private Integer typeId;
	
	@Column(name = "UNITID", nullable = false)
	private Integer  unitId;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPEID", referencedColumnName = "TYPEID", insertable=false, updatable=false)
    private MaterialType type;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UNITID", referencedColumnName = "UNITID", insertable=false, updatable=false)
    private Unit unit;
	
	

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public MaterialType getType() {
		return type;
	}

	public void setType(MaterialType type) {
		this.type = type;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	
	
	
	
	
	
}
