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
	private Integer receiveMateialDetialId;
	
	
	@Column(name = "RECEIVEMATERIAL_ID", unique=true, nullable = false)
	private Integer  receiveId;
	
	@Column(name = "MATERIALID", unique=true, nullable = false)
	private String  materialId;
	
	@Column(name = "RECEIVE_QUANTITY", unique=true, nullable = false)
	private Integer  receiveQuantity;
     
	@Column(name = "RECEIVE_PRICE", unique=true, nullable = false)
	private Integer  receivePrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIALID", referencedColumnName = "MATERIALID", insertable=false, updatable=false)
    private Material  material;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RECEIVEMATERIAL_ID", referencedColumnName = "RECEIVE_MATERIALID", insertable=false, updatable=false)
	private ReceiveMaterial receive;


	
	public Integer getReceiveMateialDetialId() {
		return receiveMateialDetialId;
	}


	public void setReceiveMateialDetialId(Integer receiveMateialDetialId) {
		this.receiveMateialDetialId = receiveMateialDetialId;
	}


	public Integer getReceiveId() {
		return receiveId;
	}


	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}


	public String getMaterialId() {
		return materialId;
	}


	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}


	public Integer getReceiveQuantity() {
		return receiveQuantity;
	}


	public void setReceiveQuantity(Integer receiveQuantity) {
		this.receiveQuantity = receiveQuantity;
	}


	public Integer getReceivePrice() {
		return receivePrice;
	}


	public void setReceivePrice(Integer receivePrice) {
		this.receivePrice = receivePrice;
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