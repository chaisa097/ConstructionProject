package com.softsquare.application.dao;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.softsquare.application.common.util.BeanUtils;
import com.softsquare.application.domain.EmployeeMapping;
import com.softsquare.application.entity.Employee;
import com.softsquare.application.entity.Login;
import com.softsquare.application.entity.Working;




@Repository()
@Component
public class EmployeeDaolmp  extends AbstractDao<Integer, Employee> implements EmployeeDao{
	
	@Autowired
	private WorkingDao workingDao;
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public ArrayList<Employee> getEmployee() {
		
		ArrayList<Working> workerList =  workingDao.findWorker();
		 Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		    criteria.createAlias("employee.departmentDetail", "departmentDetail");
		    criteria.createAlias("departmentDetail.department", "department");
		 ProjectionList projections = Projections.projectionList()				 
		            .add(Projections.property("employee.employeeId").as("employeeId"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.employeeCode").as("employeeCode"))
		            .add(Projections.property("departmentDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("departmentDetail.departmentId").as("departmentId"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"));
		 criteria.setProjection(projections);	
		 criteria.add(Restrictions.not(Restrictions.or(Restrictions.like("department.departmentCode","BA"),Restrictions.like("department.departmentCode","ST"),Restrictions.like("department.departmentCode","SECANT"))));
		 
/*		  for(int i=0;i<workerList.size();i++) {
	    criteria.add(Restrictions.not(Restrictions.like("employee.employeeId", workerList.get(i).getEmployeeId())));
		  }*/
		 
		 criteria.setResultTransformer(Transformers.aliasToBean(Employee.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<Employee> employeeList = (ArrayList<Employee>) criteria.list();
	
		return employeeList;
		 	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findNoMax() {
		 Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		 ProjectionList projections = Projections.projectionList()				  
		            .add(Projections.max("employee.employeeCode").as("employeeCode"));		         		 
		 criteria.setProjection(projections);		
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 Map<String, Object> result = (Map<String,Object>) criteria.uniqueResult();
		return result;
	}
		
	@Override
	public ArrayList<Employee> getAllEmployee() {
		 Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		    criteria.createAlias("employee.departmentDetail", "departmentDetail");
		    criteria.createAlias("departmentDetail.department", "department");
		    criteria.addOrder(Order.desc("employee.employeeId"));
		 ProjectionList projections = Projections.projectionList()				 
		            .add(Projections.property("employee.employeeId").as("employeeId"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.employeeCode").as("employeeCode"))
		            .add(Projections.property("departmentDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("departmentDetail.departmentId").as("departmentId"))
		            .add(Projections.property("department.departmentName").as("departmentName"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"));
		 criteria.setProjection(projections);	
		 criteria.setResultTransformer(Transformers.aliasToBean(Employee.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<Employee> employeeList = (ArrayList<Employee>) criteria.list();
		return employeeList;
	}
	
	@Override
	public ArrayList<Employee> getEmployeeForUserLogin() {
		ArrayList<Login> accountList =  loginDao.findUserAccount();
		 Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		    criteria.createAlias("employee.departmentDetail", "departmentDetail");
		    criteria.createAlias("departmentDetail.department", "department");
		    criteria.addOrder(Order.desc("employee.employeeId"));
		 ProjectionList projections = Projections.projectionList()				 
		            .add(Projections.property("employee.employeeId").as("employeeId"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.employeeCode").as("employeeCode"))
		            .add(Projections.property("departmentDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("departmentDetail.departmentId").as("departmentId"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"));
		 
		  for(int i=0;i<accountList.size();i++) {
			    criteria.add(Restrictions.not(Restrictions.like("employee.employeeId", accountList.get(i).getEmployeeId())));
				  }
		 criteria.setProjection(projections);	
		 criteria.setResultTransformer(Transformers.aliasToBean(Employee.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<Employee> employeeList = (ArrayList<Employee>) criteria.list();
		return employeeList;
	}
	
	
	
	
	@Override
	public ArrayList<Employee> getProjectManager() {
		         
		 Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		    criteria.createAlias("employee.departmentDetail", "departmentDetail");
		    criteria.createAlias("departmentDetail.department", "department");
		 ProjectionList projections = Projections.projectionList()				 
		            .add(Projections.property("employee.employeeId").as("employeeId"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.employeeCode").as("employeeCode"))
		            .add(Projections.property("departmentDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("departmentDetail.departmentId").as("departmentId"))
		            .add(Projections.property("department.departmentCode").as("departmentCode"));
		 criteria.setProjection(projections);
		 criteria.add(Restrictions.eq("department.departmentCode","BA"));	
		 criteria.setResultTransformer(Transformers.aliasToBean(Employee.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<Employee> employeeList = (ArrayList<Employee>) criteria.list();
		return employeeList;
	}
	
	
	
	
	
	@Override
	public  ArrayList<EmployeeMapping> findEmployee(EmployeeMapping employeeMapping) {
		Criteria criteria = getSession().createCriteria(Employee.class, "employee");		 
		 criteria.createAlias("employee.departmentDetail", "departmentDetail");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("employee.employeeId").as("employeeId"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("departmentDetail.depDetailName").as("depDetailName"))
		            .add(Projections.property("departmentDetail.depDetailId").as("depDetailId"));
		           
		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(employeeMapping.getEmployeeId())){
			 criteria.add(Restrictions.eq("employee.employeeId", employeeMapping.getEmployeeId()));			 
		 }
		 if(BeanUtils.isNotEmpty(employeeMapping.getDepDetailId())){
			 criteria.add(Restrictions.eq("employee.employeeId", employeeMapping.getDepDetailId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(EmployeeMapping.class));
		 ArrayList<EmployeeMapping> employeeList =  (ArrayList<EmployeeMapping>) criteria.list();
		return employeeList;
	}
	@SuppressWarnings("unchecked")	
	@Override
	public  ArrayList<EmployeeMapping> findEmployeeById(EmployeeMapping employeeMapping) {
		Criteria criteria = getSession().createCriteria(Employee.class, "employee");	
		criteria.createAlias("employee.departmentDetail", "departmentDetail");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("employee.employeeId").as("employeeId"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.citizenId").as("citizenId"))
		            .add(Projections.property("employee.provinceId").as("provinceId"))		      
		            .add(Projections.property("employee.district").as("district"))
		            .add(Projections.property("employee.subDistrict").as("subDistrict"))		 
		            .add(Projections.property("employee.birthDay").as("birthDay"))
		            .add(Projections.property("employee.gender").as("gender"))
		            .add(Projections.property("departmentDetail.Salary").as("Salary"))
		            .add(Projections.property("departmentDetail.depDetailId").as("depDetailId"));
		           
		 criteria.setProjection(projections);
	     criteria.add(Restrictions.eq("employee.employeeId", employeeMapping.getEmployeeId()));	
	     criteria.setResultTransformer(Transformers.aliasToBean(EmployeeMapping.class));
	     criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<EmployeeMapping> employeeList =  (ArrayList<EmployeeMapping>) criteria.list();
		return employeeList;
	}
	
	@Override
	public  ArrayList<EmployeeMapping> findEmployeeByIdForView(EmployeeMapping employeeMapping) {
		Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		criteria.createAlias("employee.province", "province");
		criteria.createAlias("employee.departmentDetail", "departmentDetail");
		criteria.createAlias("departmentDetail.department", "department");
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.property("employee.employeeId").as("employeeId"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.citizenId").as("citizenId"))
		            .add(Projections.property("employee.provinceId").as("provinceId"))		      
		            .add(Projections.property("employee.district").as("district"))
		            .add(Projections.property("employee.subDistrict").as("subDistrict"))		 
		            .add(Projections.property("employee.birthDay").as("birthDay"))
		            .add(Projections.property("employee.gender").as("gender"))
		            .add(Projections.property("province.provinceName").as("provinceName"))
		            .add(Projections.property("department.departmentName").as("departmentName"))
		            .add(Projections.property("departmentDetail.Salary").as("Salary"))
		            .add(Projections.property("departmentDetail.depDetailName").as("depDetailName"));
		 criteria.setProjection(projections);
	     criteria.add(Restrictions.eq("employee.employeeId", employeeMapping.getEmployeeId()));	
	     criteria.setResultTransformer(Transformers.aliasToBean(EmployeeMapping.class));
	     criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<EmployeeMapping> employeeList =  (ArrayList<EmployeeMapping>) criteria.list();
		return employeeList;
	}
	
	
	
	
	
	@Override
	public  ArrayList<Employee> CountEmployee() {
		Criteria criteria = getSession().createCriteria(Employee.class, "employee");		 
		 ProjectionList projections = Projections.projectionList()
				 	.add(Projections.count("employee.employeeId").as("employeeId"));           
		 criteria.setProjection(projections);
		 criteria.setResultTransformer(Transformers.aliasToBean(EmployeeMapping.class));
		 criteria.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		 ArrayList<Employee> employeeList =  (ArrayList<Employee>) criteria.list();
		return employeeList;
	}
	
	@Override
	public Employee getEmployeeForUpdate(EmployeeMapping mapping) {
		 Criteria criteria = getSession().createCriteria(Employee.class, "employee");
		 ProjectionList projections = Projections.projectionList()
		            .add(Projections.property("employee.employeeId").as("employeeId"))
		            .add(Projections.property("employee.empFirstName").as("empFirstName"))
		            .add(Projections.property("employee.empLastName").as("empLastName"))
		            .add(Projections.property("employee.employeeCode").as("employeeCode"))
		            .add(Projections.property("employee.provinceId").as("provinceId")) 
		            .add(Projections.property("employee.gender").as("gender")) 
		            .add(Projections.property("employee.district").as("district")) 
		            .add(Projections.property("employee.subDistrict").as("subDistrict")) 
		            .add(Projections.property("employee.birthDay").as("birthDay")) 
		            .add(Projections.property("employee.citizenId").as("citizenId")) 
		            .add(Projections.property("employee.startHireDate").as("startHireDate"))
		             .add(Projections.property("employee.departmentDetailId").as("departmentDetailId"));

		 criteria.setProjection(projections);
		 if(BeanUtils.isNotEmpty(mapping.getEmpFirstName())){
			 criteria.add(Restrictions.eq("employee.employeeId", mapping.getEmployeeId()));			 
		 }
		 criteria.setResultTransformer(Transformers.aliasToBean(Employee.class));
		 Employee employeeList = (Employee) criteria.uniqueResult();
		return employeeList;
	}
	
	
	@Override
	public void saveEmployee(Employee emp) throws Exception {
		save(emp);
	}

	@Override
	public void removeEmployee(Employee emp) throws Exception {
		delete(emp);
	}

	@Override
	public void updateEmployee(Employee emp) throws Exception {
		merge(emp);
	}
	
	
	

}
