<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<!-- <link rel="stylesheet" href="css/base/createproject.css">
<script src="webjars/jquery/2.1.1/jquery.min.js"></script>
 <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="dist/css/sb-admin-2.css">
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <script src="metisMenu/metisMenu.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script> -->
  <script src="bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
<link rel="stylesheet" href="css/base/createproject.css">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
<!-- daterange picker -->
<link rel="stylesheet" href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet" href="dist/css/bootstrap-datepicker.min.css">
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="plugins/iCheck/all.css">
<!-- Bootstrap Color Picker -->
<link rel="stylesheet" href="bower_components/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
<!-- Bootstrap time Picker -->
<link rel="stylesheet" href="plugins/timepicker/bootstrap-timepicker.min.css">
<!-- Select2 -->
<link rel="stylesheet" href="bower_components/select2/dist/css/select2.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<!-- DataTables -->
<link rel="stylesheet"href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">

<!-- bootstrap datepicker -->

</head>

<div name="statusSave" hidden="true"></div>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper" style="margin-top: -89px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			New <small>Project</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="${domainSystem}home.html"><i
					class="fa fa-dashboard"></i>Home</a></li>
			<li><a href="${domainSystem}listProject.html"><i
					class="fa fa-folder"></i>Manage Project</a></li>
			<li class="active">New Project</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<!-- SELECT2 EXAMPLE -->
		<div class="box box-default" name="addEditData">
			<div class="box-header with-border">
				<h3 class="box-title">Project Form</h3>

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
					<div class="col-md-2">
						<div class="form-group">

							<div>
								<label>ProjectName</label>

							</div>
							<div style="margin-top: 20px">
								<label>Description</label>
							</div>
							
							
							<div style="margin-top:60px">
								<label>Address</label>
							</div>
                          <div style="margin-top: 60px">
								<label>Customer</label>
							</div>
							<div style="margin-top: 20px">
								<label>CustomerPhone</label>
							</div>
							
							
						</div>
					</div>

					<div class="col-md-4" style="margin-left: -55px;">
						<div class="form-group">

							<div>

								<input id="proName" type="text" class="form-control"
									placeholder="Project Name" name="projectName"
									pattern="[A-Za-z]{5,10}"  required>  <span class="error">This
									field is required</span>
							</div>
							<div style="margin-top: 10px">
								<textarea id="descript" class="form-control"
									placeholder="Description" rows="3" cols="10" name="description" ></textarea>	
							</div>
							
							<div style="margin-top: 10px">
								<textarea id="address" class="form-control"
									placeholder="Address of Construction Site" rows="3" cols="10"
									name="address" ></textarea>
							</div>
							<div style="margin-top: 10px">
								<input type="text" class="form-control"
									placeholder="Customer Name" name="customerName"
									id="cusName"  >
							</div>
							<div style="margin-top: 10px">
								<input type="text" class="form-control bfh-phone"
									placeholder="Customer Phone" name="customerPhone"
									id="cusPhone" >
							</div>
							

						</div>
					</div>
					<div class="col-md-2" style="margin-left: 50px;">
						<div class="form-group">

							<div>
								<label>Province</label>

							</div>
							<div style="margin-top: 20px">
								<label>ProjectManager</label>
							</div>
                           <div style="margin-top: 20px">
								<label>StartDate</label>
							</div>
							
							  <div style="margin-top: 20px">
								<label>FinishedDate</label>
							</div>
							<div style="margin-top: 20px">
							CompleteStatus(0-100%)
							 	<span id="slider_value" style="color:red;"></span>
							
							</div>
							<div style="margin-top: 20px">
							Budget

							</div>
							<div style="margin-top: 20px">
							Critical Budget(0-100%)
							 	
							
							</div>
							
						</div>
					</div>


					<!-- /.col -->
					<div class="col-md-4">
						<div class="form-group">
							<select class="form-control select2" id="province"
								name="provinceList" data-live-search="true" data-size="5"
								data-header="Select Province" ></select>

							<div style="margin-top: 10px">
								<select class="form-control select2" id="employee"
									name="employeeList" data-live-search="true" data-size="5"
									data-header="Select ProjectManager" ></select>

							</div>
							<div style="margin-top: 10px">
                            <div class="input-group date">
                       <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                       </div>
                     <input type="date" class="form-control" name="startDate"
									id="startDate" >
								
									
                       </div>
                       </div>
                       <div style="margin-top: 10px">
                        <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                 <input type="date" class="form-control" name="finishDate"
									id="finishDate" >
                </div>
                      </div>
                       <div style="margin-top: 10px">
								<input id="Status" class="form-control" type="range"
									min="0" max="100" step="5"  value="0" onchange="show_value(this.value);"  name="percentStatus"  disabled> 
                        							</div>
                     <div style="margin-top: 10px">    							
                 <input type="number" class="form-control" placeholder="Budget"  
									name="budget" id="budget" min="0" onkeypress='event.charCode >= 0' >
									
                 </div>
                   <div style="margin-top: 10px">  
                   <input type="number" class="form-control" min="0" max="100"
								step="1" name="criticalBudget" id="critical" onkeypress='event.charCode >= 0' maxlength="3" >
                   </div>
                 
						</div>
						<!-- /.form-group -->

					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<div class="col-xs-10"></div>
				<div class="col-xs-2">
					<button onclick="save()"  data-toggle="modal" data-target="#save"
						class="btn  btn-success btn-lg">Save</button>
					<a href="${domainSystem}listProject.html" style="margin-left: 2px;"
						class="btn  btn-default btn-lg">Cancel</a>
				</div>

			</div>
		
		</div>
		<!-- /.box -->

	</section>
	<!-- /.content -->
</div>



<!-- delete alert modal box -->
<div class="modal fade bs-example-modal-sm" id="modalDelete"
	tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
	rowId="">
	<div class="modal-dialog modal-xs" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Warning</h4>
			</div>
			<div class="modal-body">
				<p>Do you really want to delete?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn-lg btn-danger" data-dismiss="modal"
					onclick="deleteRow()">Delete</button>
				<button type="button" class="btn-lg btn-warning"
					data-dismiss="modal">Cancel</button>

			</div>
		</div>
	</div>
</div>
 



</html>

