<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
      <div class="container">
	    <div class="form-group">
		<div class="panel panel-info">
			<div class="panel-heading">
				<lable class="headPanal">Manage User</lable>
			</div>
		</div>
		<div class="panel-body" style="margin-top: -25px;">

			<div class="row">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title">User</h3>

					</div>
                     
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
					 <div class="container">
						<div class="col-md-1" style="margin-top:20px; margin-bottom:5px">
							<input type="image" src="images/add.png"  onclick="addRow()"   width="80" height="48">
						</div>

						<div class="col-md-3" style="margin-top: 10px; margin-bottom: 5px">
						<label>UserName </label>
							<input type="text" class="form-control" id="userName"
								placeholder="UserName" name="name" disabled>
						</div>

						<div class="col-md-3" style="margin-top: 10px; margin-bottom: 5px">
						<label>Password </label>
							<input type="password" class="form-control" id="password"
								placeholder="Password" name="password" disabled>
						</div>

						<div class="col-md-3" style="margin-top: 10px; margin-bottom: 5px">
						<label>Re-Password </label>
							<input type="password" class="form-control" id="rePassword"
								placeholder="Re-Password" name="rePassword" disabled>
						</div>
						<div class="col-md-2" style="margin-top: 10px; margin-bottom: 5px">
						</div>
					
					
						<div class="col-md-3" style="margin-top: 10px; margin-bottom: 5px">
						<label>RoleName  </label>
							<select class="selectpicker show-tick show-menu-arrow" id="role"
								name="roleList" data-live-search="true" data-size="5"
								data-header="Select Role" disabled></select>
						</div>

						<div class="col-md-3"style="margin-top: 10px; margin-bottom: 20px">
						<label>Employee </label>
							<select class="selectpicker show-tick show-menu-arrow"
								id="employee" name="employeeList" data-live-search="true"
								data-size="5" data-header="Select Employee" disabled></select>
						</div>
						  <div class="col-md-3" style="margin-top:10px; margin-bottom:20px">
						  </div>
						
							  <div class="col-md-2" style="margin-top:30px; margin-bottom:20px">
		        	<input type="image" src="images/Save2.png"  onclick="SaveFunction()"   width="40" height="40">  
				   </div>
					
						
					
				</div>
				</div>
				
			</div>
		</div>
				
        </div>
			<div class="form-group">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="row" id="roleHeader">
							<div class="col-md-2"></div>
							<div class="col-md-4">
								<label class="control-label-required">Role</label> <select
									class="selectpicker show-tick show-menu-arrow" name="roleList"
									data-live-search="true" data-size="5" data-header="Select Role"></select>
								<button type="button" class="btn btn-info" onclick="search()">
									<span class="glyphicon glyphicon-search"></span>
								</button>

							</div>
							<div class="col-md-6"></div>
						</div>
					</div>
				</div>

				<div class="panel panel-default filterable">
					<div class="panel-heading">
						<h3 class="panel-title">User List</h3>
						<div class="pull-right">
							<button class="btn btn-default btn-xs btn-filter">
								<span class="glyphicon glyphicon-filter"></span>Filter
							</button>
						</div>
					</div>
					<table class="table">
						<thead>
							<tr class="filters">
								<th></th>
								<th><input type="text" class="form-control"
									placeholder="FirstName" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="LastName" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="UserName" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="Role" disabled></th>
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