package com.softsquare.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EXPORT_MATERIALDETAIL")
public class ExportMaterialDetail {
        
	
	@Id
    @GeneratedValue
    @Column(name = "EXPORT_MATERIALDETAILID")
	private Integer  exportMateialDetialId;
	
	
	@Column(name = "EXPORT_MATERIALID", unique=true, nullable = false)
	private Integer  exportId;
	
	@Column(name = "MATERIALID", unique=true, nullable = false)
	private Integer  materialId;
	
	@Column(name = "EXPORT_QUANTITY", unique=true, nullable = false)
	private Integer  exportQuantity;
     
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIALID", referencedColumnName = "MATERIALID", insertable=false, updatable=false)
    private Material  material;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXPORT_MATERIALID", referencedColumnName = "EXPORT_MATERIALID", insertable=false, updatable=false)
	private ExportMaterial export;


	public Integer getExportMateialDetialId() {
		return exportMateialDetialId;
	}


	public void setExportMateialDetialId(Integer exportMateialDetialId) {
		this.exportMateialDetialId = exportMateialDetialId;
	}


	public Integer getExportId() {
		return exportId;
	}


	public void setExportId(Integer exportId) {
		this.exportId = exportId;
	}


	public Integer getMaterialId() {
		return materialId;
	}


	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}


	public Integer getExportQuantity() {
		return exportQuantity;
	}


	public void setExportQuantity(Integer exportQuantity) {
		this.exportQuantity = exportQuantity;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}


	public ExportMaterial getExport() {
		return export;
	}


	public void setExport(ExportMaterial export) {
		this.export = export;
	}
	
	
	
	

}
