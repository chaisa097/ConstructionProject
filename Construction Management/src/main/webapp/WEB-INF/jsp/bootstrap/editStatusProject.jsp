<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
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
		<div class="panel panel-default">
			<div class="panel-heading">
				<lable class="headPanal">Progress Construction Project</lable>
			</div>
		</div>
		<div class="col-md-1" style="margin-top: -15px; margin-bottom:20px">
   <input type="image" src="images/Save2.png" onclick="Save()" width="48" height="48">
           </div>
		<div class="panel-body" style="margin-top:40px;">
			<div class="row">
				<div class="panel panel-info">
					<div class="panel-heading">
						<lable class="headPanal"> Project Information</lable>
					</div>
                      
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
						<div class="container">
						
						   		<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CompleteStatus(0-100%)</lable>
								<input id="percentStatus" class="form-control" type="range"
									min="0" max="100" step="10" name="percentStatus" disabled>
							</div>
						
						
						
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>ProjectName</lable>
								<input id="projectName" type="text" class="form-control"
									placeholder="Project Name" name="projectName" disabled>
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Description</lable>
								<textarea id="description" class="form-control"
									placeholder="Description" rows="3" cols="10" name="description"
									disabled></textarea>
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Address</lable>
								<textarea id="address" class="form-control"
									placeholder="Address of Construction Site" rows="3" cols="10"
									name="address" disabled></textarea>
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Province</lable>
								<select class="selectpicker show-tick show-menu-arrow" id="pv"
									name="provinceList" data-live-search="true" data-size="5"
									data-header="Select Province" disabled></select>

							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable> ProjectManager</lable>
								<select class="selectpicker show-tick show-menu-arrow" id="emp"
									name="employeeList" data-live-search="true" data-size="5"
									data-header="Select ProjectManager" disabled></select>

							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>StartDate</lable>
								<input type="date" class="form-control" name="startDate"
									id="startDate" disabled>
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>FinishDate</lable>
								<input type="date" class="form-control" name="finishDate"
									id="finishDate" disabled>
							</div>
						</div>

					</div>

				</div>

				<div class="panel panel-info">
					<div class="panel-heading">
						<lable class="headPanal"> customer Information</lable>
					</div>
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
						<div class="container">
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CustomerName</lable>
								<input type="text" class="form-control"
									placeholder="Customer Name" name="customerName"
									id="customerName" disabled>
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CustomerPhone</lable>
								<input type="text" class="form-control"
									placeholder="Customer Phone" name="customerPhone"
									id="customerPhone" disabled>
							</div>
						</div>
					</div>
			
				</div>

				<div class="panel panel-info">
					<div class="panel-heading">
						<lable class="headPanal"> budget of project</lable>
					</div>
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
						<div class="container">
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Budget</lable>
								<input type="number" class="form-control" placeholder="Budget"
									name="budget" id="bugget" disabled>
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>TotalHireEmployee/Baht</lable>
								<input type="number" class="form-control"
									name="totalHireEmployee" id="totalHireEmployee" disabled>
							</div>
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>TotalUsedMaterial/Baht</lable>
								<input type="number" class="form-control"
									name="totalUseMaterial" id="totalUseMaterial" disabled>
							</div>
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>TotalExpenseInConstruction/Baht</lable>
								<input type="number" class="form-control" name="totalExpense"
									id="totalExpense" disabled>
							</div>
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Critical Budget(0-100%)</lable>
								<input type="number" class="form-control" min="0" max="100"
									step="5" name="criticalBudget" id="criticalBudget" disabled>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div> -->
<div class="content-wrapper" style="margin-top: -89px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Progress of <small>project</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="${domainSystem}home.html"><i
					class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">Manage User</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- SELECT2 EXAMPLE -->
		<div class="box box-default" name="addEditData">
			<div class="box-header with-border">
			<div class="col-xs-12">
			<div class="col-xs-3">
				<h3 id="projectName"></h3> 
				</div>
				<div  class="col-xs-1">
				<h3 style="margin-left :-20px;" id="Status"></h3>
				</div>
				<div class="col-xs-1">
				<h3 style="margin-left :-80px;" >%</h3>
				</div>
				<div class="col-xs-2">
				<h3>TotalExpense :</h3>
				</div>
				<div class="col-xs-2">
				<h3 id="Expense"></h3>
				</div>
				<div class="col-xs-3">
						<div class="form-group">
							<label>CompleteStatus(0-100%) <span id="slider_value" style="color:red;"></span></label>
							<input id="percentStatus" class="form-control" type="range"
									min="0" max="100" step="1" onchange="show_value(this.value);" name="percentStatus" >
						</div>
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
			
				<!-- /.row -->




			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<button onclick="Save()" type="submit"
					class="btn btn-info pull-right">Save</button>
			</div>
		</div>
		<!-- /.box -->
		


	</section>
	<!-- /.content -->
</div>



</html>