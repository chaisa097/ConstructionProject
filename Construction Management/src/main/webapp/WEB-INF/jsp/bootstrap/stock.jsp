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
	<div class="form-group">
		<div class="panel panel-warning">		
		 <div class="panel-heading"><lable class="headPanal">Stock</lable>
				<div class="row" id="roleHeader">					 
					<div class="col-md-2"></div>
					<div class="col-md-4">
						<label class="control-label-required">Type</label>
						<select class="selectpicker show-tick show-menu-arrow"  name="typeList" data-live-search="true" data-size="5" data-header="Select MaterialType" ></select>
							 <button type="button" class="btn btn-info" onclick="search()">
					  <span class="glyphicon glyphicon-search"></span>
					  </button>
					</div>
				  	<div class="col-md-6"></div>
				</div>
			  </div>
		 </div>
		 <div class="panel-body" style="margin-top:-25px;">
		  <div class="row">

		        <div class="panel panel-default filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Material List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                         <th><input type="text" class="form-control" placeholder="Type" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Name" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Description" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="TotalQuantity" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Unit" disabled></th>
		                         <th><input type="text" class="form-control" placeholder="Price/Unit" disabled></th>
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