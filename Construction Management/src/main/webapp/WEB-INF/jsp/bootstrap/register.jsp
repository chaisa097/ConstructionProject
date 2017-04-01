<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
		<div class="panel panel-default">
		  <div class="panel-heading"><lable class="headPanal">Manage User</lable>
				<div class="row" id="roleHeader">
					<div class="col-md-2"></div>
					<div class="col-md-4">
						<label class="control-label-required">Role</label>
						<select class="selectpicker show-tick show-menu-arrow"  name="roleList" data-live-search="true" data-size="5" data-header="Select Role" ></select>
					</div>
				  	<div class="col-md-6"></div>
				</div>
			  </div>
		 </div>
		 <div class="panel-body" style="margin-top:-25px;">
		  <div class="row">
		 		<button type="button" class="btn btn-default" onclick="addRow()">
					<span class="glyphicon glyphicon-edit"></span> Insert
				</button> 
				      
				<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					<div class="col-md-3"style="margin-top:10px; margin-bottom:5px">
						<input type="text" class="form-control" id="userName"  placeholder="UserName" name="name" disabled>
					</div>
						<div class="col-md-1">
					</div>
					<div class="col-md-3"style="margin-top:10px; margin-bottom:5px">
						<input type="password" class="form-control" id="password" placeholder="Password" name="password" disabled>
					</div>
					
					<div class="col-md-3"style="margin-top:10px; margin-bottom:5px">
						<input type="password" class="form-control" id="rePassword"  placeholder="Re-Password" name="rePassword" disabled>
					</div>
					<div class="col-md-1">
					</div>
				
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px" >
						<select class="selectpicker show-tick show-menu-arrow"  id="role"  name="roleList" data-live-search="true" data-size="5" data-header="Select Role" disabled></select>
					</div>
			         <div class="col-md-1">
					</div>
					<div class="col-md-3"  style="margin-top:10px; margin-bottom:20px">
						<select class="selectpicker show-tick show-menu-arrow" id="employee"  name="employeeList" data-live-search="true" data-size="5" data-header="Select Employee" disabled></select>
					</div>
				</div>
			
				
		        <div class="panel panel-default filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Role List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th>Manage</th>
		                        <th><input type="text" class="form-control" placeholder="UserName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Role" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="FirstName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="LastName" disabled></th>
		                    </tr>
		                </thead>
		                <tbody>
		                </tbody>
		            </table>
		        </div>
		    </div>
		 </div>
	</div>
</div>	
</html>