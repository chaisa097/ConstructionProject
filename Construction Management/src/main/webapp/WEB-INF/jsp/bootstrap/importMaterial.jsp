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
		
		
		<button type="button" class="btn btn-primary" onclick="listRequestMaterial()">
					<span class="glyphicon glyphicon-duplicate"></span> History Of RequestMaterial
				   </button> 
				   
				   <button type="button" class="btn btn-warning" onclick="exportMaterialConfirm()">
					<span class="glyphicon glyphicon-duplicate"></span>  History Of ImportMaterial
				   </button> 
			<div class="row">

				<div class="panel panel-info filterable">
					<div class="panel-heading">
						<h3 class="panel-title">Own Project</h3>
					</div>
					<table class="table">
						<thead>
							<tr class="filters">
								<th></th>
								<th><input type="text" class="form-control"
									placeholder="ProjectName" disabled></th>
							<th><input type="text" class="form-control"
									placeholder="Budget of Project" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="UsedMaterial/Bath" disabled></th>	
								<th><input type="text" class="form-control"
									placeholder="StatusProject" disabled></th>
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