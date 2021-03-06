<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<!-- <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
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
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper" style="margin-top: -89px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Employee Information
		</h1>
		<ol class="breadcrumb">
			<li><a href="${domainSystem}home.html"><i
					class="fa fa-dashboard"></i>Home</a></li>
			<li><a href="${domainSystem}listProject.html"><i
					class="fa fa-folder"></i>Manage Employee</a></li>
			<li class="active">View Employee</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- SELECT2 EXAMPLE -->
      
		<div class="box box-default" name="addEditData">
		
			<!-- /.box-header -->
			<div class="box-body">
				<div class="row">
					<div class="col-md-2">
						<div class="form-group">

							<div>
								<label>FirstName :</label>

							</div>
							<div style="margin-top: 10px">
								<label>LastName :</label>
							</div>


							<div style="margin-top: 10px">
								<label>CitizenID :</label>
							</div>
							<div style="margin-top: 10px">
								<label>BirthDay :</label>
							</div>
							<div style="margin-top: 10px">
								<label >Gender :</label>
							</div>


						</div>
					</div>

					<div class="col-md-4">
						<div class="form-group">

							<div>

							<p id="empFirstName"></p>
							</div>
							<div style="margin-top: 10px">
						   <p id="empLastName"></p>
							</div>

							<div style="margin-top: 15px">
								<p id="citizenId"></p>
							</div>
							<div style="margin-top: 20px">
							<p id="birthDay"></p>
							</div>
							<div style="margin-top:10px">
									<p id="gender"></p>
							
							</div>


						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">

							<div >
								<label>Province :</label>

							</div>
							<div style="margin-top: 10px">
								<lable>Sub-District :</lable>
							</div>
							<div style="margin-top: 10px">
							 <lable>District :</lable>
							</div>

							<div style="margin-top: 15px">
								<label>Department :</label>
							</div>
							<div style="margin-top: 5px">
							  	<label>Position :</label>

							</div>
								<div style="margin-top: 2px">
							  	<label>Salary :</label>

							</div>

						</div>
					</div>


					<!-- /.col -->
					<div class="col-md-4">
						<div class="form-group">

							<div >
									<p id="provinceName"></p>

							</div>
							<div style="margin-top: 10px">
									<p id="subDistrict"></p>
							</div>
							<div  style="margin-top: 10px">
									<p id="district"></p>
							</div>
							<div style="margin-top: 20px">
						    	<p id="departmentName"></p>
							</div>
							
							<div style="margin-top: 10px">
						    	<p id="depDetailName"></p>
							</div>
							<div style="margin-top: 5px">
						    	<p id="Salary"></p>
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
			<button type="button" class="btn btn-primary" onclick="back()">
					Back
				   </button> 
			</div>
		</div>	
		<!-- /.box -->
	</section>
	<!-- /.content -->
</div>
</html>