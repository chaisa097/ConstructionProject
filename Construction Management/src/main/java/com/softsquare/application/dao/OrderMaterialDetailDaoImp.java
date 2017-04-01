package com.softsquare.application.dao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.softsquare.application.entity.OderMaterialDetail;


@Repository()
@Component
public class OrderMaterialDetailDaoImp extends AbstractDao<Integer, OderMaterialDetail> implements OrderMaterialDetailDao {
	
	@Override
	public void saveOrderMaterial(OderMaterialDetail orderdetail) throws Exception {
		save(orderdetail);
	}
	
	
}
