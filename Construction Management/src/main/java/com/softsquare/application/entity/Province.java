package com.softsquare.application.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

	
	@Entity
	@Table(name = "PROVINCE")
	public class Province implements Serializable {
		
		private static final long serialVersionUID = 6019490232774665003L;

		@Id
	    @GeneratedValue
	    @Column(name = "PROVINCEID")
		private Integer provinceId;
		
		@NotEmpty
		@Column(name = "PROVINCECODE", unique=true, nullable = false)
		private String  provinceCode;
		
		@Column(name = "PROVINCENAME", unique=true, nullable = false)
		private String  provinceName;

		public Integer getProvinceId() {
			return provinceId;
		}

		public void setProvinceId(Integer provinceId) {
			this.provinceId = provinceId;
		}

		public String getProviceCode() {
			return provinceCode;
		}

		public void setProviceCode(String proviceCode) {
			this.provinceCode = proviceCode;
		}

		public String getProvinceName() {
			return provinceName;
		}

		public void setProvinceName(String provinceName) {
			this.provinceName = provinceName;
		}
		


}
