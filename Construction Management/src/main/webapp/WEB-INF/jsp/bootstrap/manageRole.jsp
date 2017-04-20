<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
		 <div class="panel-body" style="margin-top:-25px;">
		 
		 
		 
		 
		  <div class="row">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title">Role</h3>

					</div>
				<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
				
				   <div class="col-md-1">
				     </div>
					
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px">
						<input id="roleCode" id="roleCode" type="text" class="form-control" placeholder="Role Code" name="roleCode" disabled>
					</div>
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px">
						<input id="roleName" id="roleName"  type="text" class="form-control" placeholder="Role Name" name="roleName" disabled>
					</div>
					
					  <div class="col-md-2" style="margin-top:10px; margin-bottom:20px">
		        	<input type="image" src="images/Save2.png"  onclick="SaveFunction()"   width="40" height="40">  
				   </div>
					
				</div>
				</div>
		        <div class="panel panel-info filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Role List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th></th>
		                        <th><input  type="text" class="form-control" placeholder="Role Code" disabled></th>
		                        <th><input  type="text" class="form-control" placeholder="Role Name" disabled></th>
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