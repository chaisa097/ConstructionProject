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
@Table(name = "REQUEST_MATERIALDETAIL")
public class RequestMaterialDetail  implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7460097800920865230L;

	
	@Id
    @GeneratedValue
    @Column(name = "REQUEST_MATERIALDETAIID")
	private Integer   requestMaterialDetailId;
	

	@Column(name = "MATERIALID", unique=true, nullable = false)
	private Integer  materialId;
	
	@Column(name = "REQUEST_MATERIALID", unique=true, nullable = false)
	private Integer  requestMaterialId;
	
	@Column(name = "QUANTITY_REQUEST", unique=true, nullable = false)
	private Integer  quantityRequest;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIALID", referencedColumnName = "MATERIALID", insertable=false, updatable=false)
    private Material material;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUEST_MATERIALID", referencedColumnName = "REQUEST_MATERIALID", insertable=false, updatable=false)
    private RequestMaterial  requestMaterial;


	public Integer getRequestMaterialDetailId() {
		return requestMaterialDetailId;
	}


	public void setRequestMaterialDetailId(Integer requestMaterialDetailId) {
		this.requestMaterialDetailId = requestMaterialDetailId;
	}


	public Integer getMaterialId() {
		return materialId;
	}


	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}


	public Integer getRequestMaterialId() {
		return requestMaterialId;
	}


	public void setRequestMaterialId(Integer requestMaterialId) {
		this.requestMaterialId = requestMaterialId;
	}


	public Integer getQuantityRequest() {
		return quantityRequest;
	}


	public void setQuantityRequest(Integer quantityRequest) {
		this.quantityRequest = quantityRequest;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public RequestMaterial getRequestMaterial() {
		return requestMaterial;
	}


	public void setRequestMaterial(RequestMaterial requestMaterial) {
		this.requestMaterial = requestMaterial;
	}


	



	
	
	
}
