<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<div class="panel-body" style="margin-top: -25px;">

			<div class="row">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title">Material</h3>

					</div>
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
                   <div class="container">
						<div class="col-md-1">
							<input type="image" src="images/add.png" onclick="addRow()"
								width="80" height="48">
						</div>

						<div class="col-md-3" >
							<label>MaterialCode</label> <input id="matCode" type="text"
								class="form-control" placeholder="Material Code"
								name="materialCode" disabled>
						</div>

						<div class="col-md-4" >
							<label>MaterialName</label> <input id="matName" type="text"
								class="form-control" placeholder="Material Name"
								name="materialName" disabled>
						</div>

						<div class="col-md-4" >
							<label>Description</label> 
							<textarea id="descript" class="form-control"
								placeholder="Description" rows="3" cols="10" name="description" disabled></textarea>
						
					
						
						
						</div>
				     <div class="col-md-1" >
				     </div>

				    	<div class="col-md-3" >
					         <label>type</label> 
							<select class="selectpicker show-tick show-menu-arrow" id="type"
								name="typeList" data-live-search="true" data-size="5"
								data-header="Select Type" disabled></select>
				     	</div>
						<div class="col-md-3">
						  <label>Unit</label> 
							<select class="selectpicker show-tick show-menu-arrow" id="unit"
								name="unitList" data-live-search="true" data-size="5"
								data-header="Select Unit" disabled></select>
						</div>
						
						<div class="col-md-2" style="margin-top: 10px; margin-bottom: 10px">
							<input type="image" src="images/Save2.png" onclick="save()"
								width="40" height="40">
						</div>
                    </div>
					</div>
				</div>
				<div class="panel panel-info filterable">
					<div class="panel-heading">
						<h3 class="panel-title">Material List</h3>
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
									placeholder="Type" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="MaterialName" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="Description" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="Unit" disabled></th>
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