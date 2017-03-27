package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIALTYPE")
public class MaterialType implements Serializable{
	
	private static final long serialVersionUID = 6019490232774665003L;
	
	@Id
    @GeneratedValue
    @Column(name = "TYPEID")
	private Integer typeId;
	
	
	@Column(name = "TYPECODE", nullable = false)
	private String  typeCode;
	
	@Column(name = "TYPENAME", nullable = false)
	private String  typeName;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	

		
}
