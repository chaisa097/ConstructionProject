<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<!--  <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="dist/css/sb-admin-2.css">
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="metisMenu/metisMenu.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script> -->
  
  <meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="bower_components/Ionicons/css/ionicons.min.css">
<!-- daterange picker -->
<link rel="stylesheet"
	href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet" href="dist/css/bootstrap-datepicker.min.css">
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="plugins/iCheck/all.css">
<!-- Bootstrap Color Picker -->
<link rel="stylesheet"
	href="bower_components/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
<!-- Bootstrap time Picker -->
<link rel="stylesheet"
	href="plugins/timepicker/bootstrap-timepicker.min.css">
<!-- Select2 -->
<link rel="stylesheet"
	href="bower_components/select2/dist/css/select2.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">

<!-- bootstrap datepicker -->
<script
	src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
  
  
  
</head>
<div name="statusSave" hidden="true"></div>
<!-- <div class="container">
	<div class="form-group">
		<div class="panel-body" style="margin-top: -25px;">
			<div class="row">
				<div class="panel panel-info">
					<div class="panel-heading">
					<lable class="headPanal"><p id="projectName"></p></lable>
									
					</div>
                    </div>
                    
                    	<div class="panel panel-warning">
					        <div class="panel-heading">
           
						<div class="row" style="margin-top: 10px; margin-bottom: -5px"
							name="addEditData">
							
						
									
					
							
							
							<div class="col-md-1"
								style="margin-top: 10px; margin-bottom: 5px"></div>

							<div class="col-md-1"
								style="margin-top: 20px; margin-bottom: 5px">

								<input type="image" src="images/add.png"  onclick="addRow()"   width="80" height="48">
							</div>

							<div class="col-md-3"
								style="margin-top: 10px; margin-bottom: 20px">
								<label  class="control-label-required" >Employee</label>
								<select class="selectpicker show-tick show-menu-arrow"
									id="employee" name="employeeList" data-live-search="true"
									data-size="5" data-header="Select Employee" disabled></select>
							</div>

							<div class="col-md-3"
								style="margin-top: 10px; margin-bottom: 5px">
								<label>Amount Of Month</label>
								<input type="text" class="form-control" id="amountOfmonth"
									placeholder="amountOfMonth" name="amountOfMonth" disabled>
							</div>
                           		  <div class="col-md-2" style="margin-top:30px; margin-bottom:20px">
		        	   <input type="image" src="images/Save2.png"  onclick="save()"   width="40" height="40">  
				      </div>
					

						</div>

                       </div>
                    </div>




						<div class="panel panel-default filterable">
							<div class="panel-heading">
								<h3 class="panel-title">Employee List</h3>
								
							</div>
							<table class="table">
								<thead>
									<tr class="filters">
										<th></th>
										<th ><input type="text" class="form-control"
											placeholder="EmployeeName" disabled></th>
										<th><input type="text" class="form-control"
											placeholder="Position" disabled></th>
										<th ><input type="text" class="form-control"
											placeholder="Salary" disabled></th>
										<th ><input type="text" class="form-control"
											placeholder="AmountOfWorking/month" disabled></th>
										<th ><input   style="text-align:right" type="text" class="form-control"
											placeholder="Total/people" disabled></th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
							<div class="col-md-4">
							</div>

						  <div class="col-md-2">
						  </div>
							<div class="col-md-3">
								<lable class="headPanal"> Total Employee Hire:</lable>
							</div>
							
							<div class="col-md-2">
							
								<lable class="headPanal"><p id="totalHireEmployee"></p></lable>
							</div>
						
				</div>
			</div>
		</div>
	</div> -->
	
	<div class="content-wrapper" style="margin-top: -89px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
	
		<h1>
			Manage <small>Worker</small>
		</h1>
		<ol class="breadcrumb">
				<li><a href="${domainSystem}home.html"><i
					class="fa fa-dashboard"></i>Home</a></li>
					<li><a href="${domainSystem}listProjectPM.html"><i
					class="fa fa-folder"></i>Manage Project</a></li>
			<li class="active">Add Employee</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- SELECT2 EXAMPLE -->
		<div class="box box-default" name="addEditData">
			<div class="box-header with-border">
			<div class="col-xs-8">
			<div class="col-xs-2">
				<h3 class="box-title">Selecting Worker</h3> 
				</div>
				<div class="col-xs-3">
				<p id="projectName"></p> 
				</div>
				
              </div>
           
				<div class="box-tools pull-right">
					<button type="button" class="btn btn-box-tool"
						data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<div class="row">

					<div class="col-xs-6">
						<div class="form-group">
							<label>Employee</label>
							 <select class="form-control select2"
								id="employee" name="employeeList" data-live-search="true" data-size="5"
								data-header="Select Employee"></select>
						</div>
					</div>
					<div class="col-xs-6">
				
								<label>Amount Of Month</label>
								<input type="number" class="form-control" id="amountOfmonth"
									placeholder="amountOfMonth" name="amountOfMonth"  min="0" onkeypress='event.charCode >= 0' >
					</div>
				


				</div>
				<!-- /.row -->




			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button onclick="save()" type="submit"
					class="btn btn-info pull-right">Save</button>
			</div>
		</div>
		<!-- /.box -->
		<div class="panel panel-info filterable">
			<div class="box">
				
				<div class="box-header">
				<div class="col-xs-2">
					<h3 style="margin-top:3px;margin-left: -8px; " class="box-title">List worker</h3>
					</div>
			
				
						
						
				</div>
				<!-- /.box-header -->
				<div class="box-body">
				
					<table class="table">
						<thead>
							<tr class="filters">
										<th></th>
										<th ><input type="text" class="form-control"
											placeholder="EmployeeName" disabled></th>
										<th><input type="text" class="form-control"
											placeholder="Position" disabled></th>
										<th ><input type="text" class="form-control"
											placeholder="Salary" disabled></th>
										<th ><input type="text" class="form-control"
											placeholder="AmountOfworking" disabled></th>
										<th ><input   style="text-align:right" type="text" class="form-control"
											placeholder="Total/people" disabled></th>
							</tr>
						</thead>
						<tbody>
						</tbody>

					</table>
					<div class="col-md-9">
					
					</div>
					<div class="col-xs-3">
						<div class="col-xs-2">
						<lable class="headPanal" >TotalAll:</lable>
							</div>
					<div class="col-xs-2">
					 <lable ><p id="totalHireEmployee"></p></lable>
					</div>
					</div>
					
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>


	</section>
	<!-- /.content -->
</div>
	
	
</html>