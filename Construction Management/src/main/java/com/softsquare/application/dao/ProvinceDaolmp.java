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
import com.softsquare.application.domain.ProvinceMapping;
import com.softsquare.application.entity.Province;

@Repository()
@Component
public  class ProvinceDaolmp extends AbstractDao<Integer, Province> implements ProvinceDao {
	
	@Override
	public ArrayList<Province> getProvince() {
		 Criteria criteria = getSession().createCriteria(Province.class, "province");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("province.provinceId").as("provinceId"))
		            .add(Projections.property("province.provinceCode").as("provinceCode"))
		            .add(Projections.property("province.provinceName").as("provinceName"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Province.class));
		 ArrayList<Province> provinceList = (ArrayList<Province>) criteria.list();
		return provinceList;
	}
	
	@Override
	public ArrayList<ProvinceMapping> findProvince(ProvinceMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Province.class, "province");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("province.provinceId").as("provinceId"))
		            .add(Projections.property("province.provinceCode").as("provinceCode"))
		            .add(Projections.property("province.provinceName").as("provinceName"));
	
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Province.class));
		 
		//set Paging
			if(BeanUtils.isNotNull(mapping.gridStore_start) && BeanUtils.isNotNull(mapping.gridStore_limit)){
				criteria.setFirstResult(mapping.gridStore_start).setMaxResults(mapping.gridStore_limit);
			}
		 ArrayList<ProvinceMapping> provinceList = (ArrayList<ProvinceMapping>) criteria.list();
		return provinceList;
	}
	
	/*paging total Records*/
	@Override
	public Integer findProvincePaging(ProvinceMapping mapping) {
		Criteria criteria = getSession().createCriteria(Province.class, "province");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("province.provinceId").as("provinceId"));
		            
		 criteria.setProjection(projections);
		 return Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
	}

	@Override
	public Province getProvinceForUpdate(ProvinceMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Province.class, "province");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("province.provinceId").as("provinceId"))
		            .add(Projections.property("province.provinceCode").as("provinceCode"))
		            .add(Projections.property("province.provinceName").as("provinceName"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getProvinceCode())){
			 criteria.add(Restrictions.eq("province.provinceId", mapping.getProvinceId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Province.class));
		 Province provinceList = (Province) criteria.uniqueResult();
		return provinceList;
	}
	
	
			
	@Override
	public void saveProvince(Province province) throws Exception {
		save(province);
	}
	
	
	@Override
	public void removeProvince(Province province) throws Exception {
		delete(province);
	}

	@Override
	public void updateProvince(Province province) throws Exception {
		merge(province);
	}

	
	
}
