package com.softsquare.application.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.DepartmentMapping;
import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.entity.Department;
import com.softsquare.application.entity.Province;

@Repository()
@Component
public  class DepartmentDaoImp extends AbstractDao<Integer, Department> implements DepartmentDao {
	
	@Override
	public ArrayList<Department> getDepartment() {
		 Criteria criteria = getSession().createCriteria(Department.class, "department");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("department.departmentId").as("departmentId"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"))
		            .add(Projections.property("department.departmentName").as("departmentName"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Department.class));
		 ArrayList<Department> departmentList = (ArrayList<Department>) criteria.list();
		return departmentList;
	}
	
	

	@Override
	public Department getDepartmentForUpdate(DepartmentMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Department.class, "department");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("department.departmentId").as("departmentId"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"))
		            .add(Projections.property("department.departmentName").as("departmentName"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getDepartmentCode())){
			 criteria.add(Restrictions.eq("department.departmentId", mapping.getDepartmentId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Department.class));
		 Department departmentList = (Department) criteria.uniqueResult();
		return departmentList;
	}
	
	
			
	@Override
	public void saveDepartment(Department dep) throws Exception {
		save(dep);
	}
	
	
	@Override
	public void removeDepartment(Department dep) throws Exception {
		delete(dep);
	}

	@Override
	public void updateDepartment(Department dep) throws Exception {
		merge(dep);
	}

	
	
}
