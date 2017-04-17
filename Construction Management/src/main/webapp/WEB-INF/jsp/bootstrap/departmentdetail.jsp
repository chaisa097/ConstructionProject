<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
   <div class="container">              	
		    <div class="panel-body" style="margin-top:50px;">	
		        <div class="row">		  
		 		<button type="button" class="btn btn-default" onclick="addRow()">
						<span class="glyphicon glyphicon-edit"></span> Insert
				</button> 
			    	<div class="row" style="margin-top:10px; margin-bottom:5px" name="addEditData">
					<div class="col-md-3">
						<select class="selectpicker show-tick show-menu-arrow" id="pv"
						name="departmentList" data-live-search="true" data-size="5"
									data-header="Select Department" disabled></select>
					</div>
					<div class="col-md-3">
						<input type="text" id="depDetailName" class="form-control" placeholder="Department Detail Name" name="depDetailName" disabled>
					 </div>
					<div class="col-md-3">
						<input type="text" id="Salary" class="form-control" placeholder="Salary" name="Salary" disabled>
					 </div>
					
				</div>
		        <div class="panel panel-info filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Department</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th>Manage</th>
		                        <th><input type="text" class="form-control" placeholder="Department Name" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Department Detail Name" disabled></th>
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