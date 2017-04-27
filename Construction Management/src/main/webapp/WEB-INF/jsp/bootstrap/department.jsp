<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
 <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="dist/css/sb-admin-2.css">
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="metisMenu/metisMenu.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</head>
<div name="statusSave" hidden="true"></div>
   <div class="container">              	
		    <div class="panel-body" style="margin-top:20px;">	
		        <div class="row">		  
		             <div class="panel panel-info">
		       <div class="panel-heading">
		                <h3 class="panel-title">Department</h3>
		              
		                </div>
		              
		                
			    	<div class="row" style="margin-top:10px; margin-bottom:5px" name="addEditData">
			    	
			    	
			    	<div class="col-md-1" style="margin-top:3px; margin-bottom:5px" >
			    	<input type="image" src="images/add.png"  onclick="addRow()"   width="80" height="48">
			    	</div>
			    	
					<div class="col-md-3" style="margin-top:1px; margin-bottom:5px" >
					<label>DepartmentCode</label>
						<input type="text" id="departmentCode" class="form-control" placeholder="DepartmentCode" name="departmentCode" disabled>
					</div>
					<div class="col-md-3" style="margin-top:1px; margin-bottom:5px" >
					<label>DepartmentName</label>
						<input type="text" id="departmentName" class="form-control" placeholder="DepartmentName" name="departmentName" disabled>
					 </div>
					 
                     <div class="col-md-2" style="margin-top:10px; margin-bottom:5px">
		        	<input type="image" src="images/Save2.png"  onclick="save()"   width="40" height="40">  
				   </div>
				</div>
				
				</div>
		        <div class="panel panel-info filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Department List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th></th>
		                        <th><input type="text" class="form-control" placeholder="Department Code" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Department Name" disabled></th>
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