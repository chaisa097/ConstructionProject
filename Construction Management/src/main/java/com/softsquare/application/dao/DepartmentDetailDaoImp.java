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
import com.softsquare.application.domain.DepartmentDetailMapping;
import com.softsquare.application.domain.DepartmentMapping;
import com.softsquare.application.domain.EmployeeMapping;
import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.entity.Department;
import com.softsquare.application.entity.DepartmentDetail;
import com.softsquare.application.entity.Employee;
import com.softsquare.application.entity.Province;

@Repository()
@Component
public  class DepartmentDetailDaoImp extends AbstractDao<Integer, DepartmentDetail> implements DepartmentDetailDao {
	
// find All Department detail 
	@Override
	public ArrayList<DepartmentDetail> findAllDepartmentDetail() {
		 Criteria criteria = getSession().createCriteria(DepartmentDetail.class, "depDetail");
		    criteria.createAlias("depDetail.department", "department");
		 ProjectionList projections = Projections.projectionList()				 
		            .add(Projections.property("depDetail.depDetailId").as("depDetailId"))
		            .add(Projections.property("depDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("depDetail.departmentId").as("departmentId"))
		            .add(Projections.property("depDetail.Salary").as("Salary"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"));
		 criteria.setProjection(projections);	
		 criteria.setResultTransformer(Transformers.aliasToBean(DepartmentDetail.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);// use  mapping "createAlias " get column on parent 
		 ArrayList<DepartmentDetail> depList = (ArrayList<DepartmentDetail>) criteria.list();
		return depList;
	}
	
	@Override
	public ArrayList<DepartmentDetailMapping> findDepartmentDetail(DepartmentDetailMapping mapping ) {
		 Criteria criteria = getSession().createCriteria(DepartmentDetail.class, "depDetail");
		    criteria.createAlias("depDetail.department", "department");
		 ProjectionList projections = Projections.projectionList()				 
		            .add(Projections.property("depDetail.depDetailId").as("depDetailId"))
		            .add(Projections.property("depDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("depDetail.departmentId").as("departmentId"))
		            .add(Projections.property("depDetail.Salary").as("Salary"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"));
		 criteria.setProjection(projections);	
		 criteria.add(Restrictions.eq("depDetail.depDetailId", mapping.getDepDetailId()));	
		 criteria.setResultTransformer(Transformers.aliasToBean(DepartmentDetail.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<DepartmentDetailMapping> depList = (ArrayList<DepartmentDetailMapping>) criteria.list();
		return depList;
	}
	
	// list All department Detail 
	@Override
	public ArrayList<DepartmentDetail> AllDepartmentDetail(int departmentId ) {
		 Criteria criteria = getSession().createCriteria(DepartmentDetail.class, "depDetail");
		    criteria.createAlias("depDetail.department", "department");
		 ProjectionList projections = Projections.projectionList()				 
		            .add(Projections.property("depDetail.depDetailId").as("depDetailId"))
		            .add(Projections.property("depDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("depDetail.Salary").as("Salary"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"))
		           .add(Projections.property("department.departmentId").as("departmentId"));
		 criteria.setProjection(projections);	
		 criteria.add(Restrictions.eq("departmentId", departmentId));	
		 criteria.setResultTransformer(Transformers.aliasToBean(DepartmentDetail.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<DepartmentDetail> depList = (ArrayList<DepartmentDetail>) criteria.list();
		return depList;
	}
	
    // this method for return only one result 
	@Override
	public DepartmentDetail getDepartmentDetailForUpdate(DepartmentDetailMapping mapping) {	
	
		 Criteria criteria = getSession().createCriteria(DepartmentDetail.class, "depDetail");//get from entity
		 ProjectionList projections = Projections.projectionList()// find value of each column in database
		            .add(Projections.property("depDetail.depDetailId").as("depDetailId"))
		            .add(Projections.property("depDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("depDetail.Salary").as("Salary"))
		            .add(Projections.property("depDetail.departmentId").as("departmentId"));
		 criteria.setProjection(projections);
		 // check for when receive value form front end should not  empty
		 if(BeanUtils.isNotEmpty(mapping.getDepDetailId())){
			 criteria.add(Restrictions.eq("depDetail.depDetailId", mapping.getDepDetailId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(DepartmentDetail.class));
		 DepartmentDetail depList = (DepartmentDetail) criteria.uniqueResult();// get one object
		return depList;
	}
	 
	
			
	@Override
	public void saveDepartmentDetail(DepartmentDetail dep) throws Exception {
		save(dep);
	}
	
	
	@Override
	public void removeDepartmentDetail(DepartmentDetail dep) throws Exception {
		delete(dep);
	}

	@Override
	public void updateDepartmentDetail(DepartmentDetail dep) throws Exception {
		merge(dep);
	}

	
	
}
