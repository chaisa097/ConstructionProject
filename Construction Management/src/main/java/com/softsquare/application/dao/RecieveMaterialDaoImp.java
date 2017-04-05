package com.softsquare.application.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.entity.ReceiveMaterial;

@Repository()
@Component
public class RecieveMaterialDaoImp extends AbstractDao<Integer, ReceiveMaterial> implements ReceiveMateriallDao{

	
	

	@Override
	public void ReceiveMaterialSave(ReceiveMaterial receive) throws Exception {
		save(receive);
	}
	@Override
	public void UpdateReceiveMaterial(ReceiveMaterial receive) throws Exception {
		merge(receive);
	}
	
	

	
	
	
}
