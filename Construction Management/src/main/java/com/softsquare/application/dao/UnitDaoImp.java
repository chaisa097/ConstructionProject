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
import com.softsquare.application.domain.UnitMapping;
import com.softsquare.application.entity.Unit;

@Repository()
@Component
public class UnitDaoImp extends AbstractDao<Integer, Unit> implements UnitDao{
	
	@Override
	public ArrayList<Unit> getUnit() {
		 Criteria criteria = getSession().createCriteria(Unit.class, "unit");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("unit.unitId").as("unitId"))
		            .add(Projections.property("unit.unitCode").as("unitCode"))
		            .add(Projections.property("unit.unitName").as("unitName"));
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(Unit.class));		 
		 ArrayList<Unit> unitList = (ArrayList<Unit>) criteria.list();
		return unitList;
	}

	@Override
	public Unit getUnitForUpdate(UnitMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Unit.class, "unit");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("unit.unitId").as("unitId"))
		            .add(Projections.property("unit.unitCode").as("unitCode"))
		            .add(Projections.property("unit.unitName").as("unitName"));
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getUnitId())){
			 criteria.add(Restrictions.eq("unit.unitId", mapping.getUnitId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Unit.class));
		 Unit resultList = (Unit) criteria.uniqueResult();
		return resultList;
	}
	
	
	

	@Override
	public void SaveUnit(Unit unit) throws Exception {
		save(unit);
	}

	@Override
	public void UpdateUnit(Unit unit) throws Exception {
		merge(unit);
	}

	@Override
	public void DeleteUnit(Unit unit) throws Exception {
		delete(unit);
	}

	

}
