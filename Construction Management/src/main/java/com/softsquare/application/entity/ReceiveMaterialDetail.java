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
@Table(name = "RECEIVE_MATERIALDETAIL")
public class ReceiveMaterialDetail implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -137846532461238687L;


	@Id
    @GeneratedValue
    @Column(name = "RECEIVE_MATERIALDETAILID")
	private Integer receiveMateialId;
	
	
	@Column(name = "RECEIVE_MATERIALID", unique=true, nullable = false)
	private String  receiveId;
	
	@Column(name = "MATERAILID", unique=true, nullable = false)
	private String  materialId;
	
	@Column(name = "RECEIVE_PRICE", unique=true, nullable = false)
	private String  receiveMaterialNo;
	
	@Column(name = "RECEIVE_QUANTITY", unique=true, nullable = false)
	private String  receiveQuantity;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIALID", referencedColumnName = "MATERIALID", insertable=false, updatable=false)
    private Material  material;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECEIVE_MATERIALID", referencedColumnName = "RECEIVE_MATERIALID", insertable=false, updatable=false)
    private ReceiveMaterial receive;


	public Integer getReceiveMateialId() {
		return receiveMateialId;
	}


	public void setReceiveMateialId(Integer receiveMateialId) {
		this.receiveMateialId = receiveMateialId;
	}


	public String getReceiveId() {
		return receiveId;
	}


	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}


	public String getMaterialId() {
		return materialId;
	}


	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}


	public String getReceiveMaterialNo() {
		return receiveMaterialNo;
	}


	public void setReceiveMaterialNo(String receiveMaterialNo) {
		this.receiveMaterialNo = receiveMaterialNo;
	}


	public String getReceiveQuantity() {
		return receiveQuantity;
	}


	public void setReceiveQuantity(String receiveQuantity) {
		this.receiveQuantity = receiveQuantity;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public ReceiveMaterial getReceive() {
		return receive;
	}


	public void setReceive(ReceiveMaterial receive) {
		this.receive = receive;
	}
	
	
	
	
	
}
