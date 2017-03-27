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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "DEPARTMENTDETAIL")
public class DepartmentDetail implements Serializable {

		
		private static final long serialVersionUID = 6019490232774665003L;

		@Id
	    @GeneratedValue
	    @Column(name = "DEPARTMENTDETAILID")
		private Integer depDetailId;
		
		
		@NotEmpty
		@Column(name = "DEPARTMENT_DETAIL_NAME", unique=true, nullable = false)
		private String  depDetailName;
		
		@Column(name = "DEPARTMENTID", nullable = false)
	    private Integer departmentId;
		
		@Column(name = "SALARY", nullable = false)
	    private Integer Salary;
		
		@ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "DEPARTMENTID", referencedColumnName = "DEPARTMENTID", insertable=false, updatable=false)
	    private Department department;
		
		

		public Integer getDepDetailId() {
			return depDetailId;
		}

		public void setDepDetailId(Integer depDetailId) {
			this.depDetailId = depDetailId;
		}

		public String getDepDetailName() {
			return depDetailName;
		}

		public void setDepDetailName(String depDetailName) {
			this.depDetailName = depDetailName;
		}

		public Integer getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Integer departmentId) {
			this.departmentId = departmentId;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Integer getSalary() {
			return Salary;
		}

		public void setSalary(Integer salary) {
			Salary = salary;
		}
		
        
		
		
		

}
