<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
   <div class="container">              	
		    <div class="panel-body" style="margin-top:20px;">	
		        <div class="row">		  
		    <div class="panel panel-info">
		       <div class="panel-heading">
		                <h3 class="panel-title">DepartmentDetail</h3>
		              
		               </div>
			    	<div class="row" style="margin-top:10px; margin-bottom:5px" name="addEditData">
			    	
			    	<div class="col-md-1" style="margin-top:20px; margin-bottom:5px" >
			    	<input type="image" src="images/add.png"  onclick="addRow()"   width="80" height="48">
			    	</div>
			    	
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px">
					<label>DepartmentName</label>
						<select class="selectpicker show-tick show-menu-arrow" id="pv"
						name="departmentList" data-live-search="true" data-size="5"
									data-header="Select Department" disabled></select>
					</div>
					<div class="col-md-3"style="margin-top:10px; margin-bottom:5px">
					<label>PositionName</label>
						<input type="text" id="depDetailName" class="form-control" placeholder="DepartmentDetail Name" name="depDetailName" disabled>
					 </div>
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px">
					<label>Salary</label>
						<input type="text" id="Salary" class="form-control" placeholder="Salary" name="Salary" disabled>
					 </div>
					 
					  <div class="col-md-1" style="margin-top:20px; margin-bottom:30px">
		        	<input type="image" src="images/Save2.png"  onclick="save()"   width="40" height="40">  
				   </div>
				   
				   
					</div>
					
					
					
					
				</div>
		        <div class="panel panel-info filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Position List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th></th>
		                        <th><input type="text" class="form-control" placeholder="DepartmentCode" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="PositionName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Salary" disabled></th>
		                    </tr>
		                </thead>
		                <tbody>
		                </tbody>
		            </table>
		        </div>
		    </div>
		 </div>
	</div>

</html>