<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<link rel="stylesheet"
	href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
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
</head>
<div name="statusSave" hidden="true"></div>
<!-- <div class="container">
	<div class="form-group">	
		<div class="panel panel-warning">
		  <div class="panel-heading"><lable class="headPanal">RequestMaterial</lable>
	
				<div class="row" id="roleHeader">
					<div class="col-md-2"></div>
					<div class="col-md-5">
						<label class="control-label-required">Form Project</label>
						<select class="selectpicker show-tick show-menu-arrow"  name="projectList" data-live-search="true" data-size="5" data-header="Select Project" ></select>
						 <button type="button" class="btn btn-info" onclick="search()">
				     	<span class="glyphicon glyphicon-search"></span>
					  </button>
					</div>
				  	<div class="col-md-6"></div>
				</div>
      </div>
		 </div>
		        <div class="panel panel-info filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title"> List RequestMaterial</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                       <th></th>
		                        <th><input type="text" class="form-control" placeholder="ProjectName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="RequestNo" disabled></th>
		                         <th><input type="text" class="form-control" placeholder="Status" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Date" disabled></th>
		                    </tr>
		                </thead>
		                <tbody>
		                </tbody>
		            </table>
		        </div>
		    </div>
		 </div>
	</div>
</div>	 -->

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper" style="margin-top: -89px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Export<small>Material</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="${domainSystem}home.html"><i
					class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">Export Material</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- /.box -->
		<div class="panel panel-info filterable">
			<div class="box">
				
				<div class="box-header">
				<div class="col-xs-2">
					<h3 style="margin-top:3px;margin-left: -8px; " class="box-title">List RequestMaterial </h3>
					</div>
				<div class="col-xs-5">
					
			   	<div style="margin-left:3px; " class="row" id="roleHeader">
							
								<label style="color:red;">*Project</label> <select
									class="selectpicker show-tick show-menu-arrow" name="projectList"
									data-live-search="true" data-size="5" data-header="Select Project"></select>
								
								<button style="margin-left:-4px;font-size:20px" type="button" class="btn btn-info" onclick="search()">
									<span class="glyphicon glyphicon-search"></span>
								</button>
                           </div>
                          <!--  roleHeader End	 -->
						</div>
						 <ul class="nav navbar-nav">
					<!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-danger">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <!-- inner menu: contains the actual data -->
                <ul class="menu">
                 
                </ul>
              
            </ul>
          </li>
		</ul>
					
						
				</div>
				<!-- /.box-header -->
				<div class="box-body">
				
					<table class="table">
						<thead>
							<tr class="filters">
								<th></th>
							   <th><input type="text" class="form-control" placeholder="ProjectName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="RequestNo" disabled></th>
		                         <th><input type="text" class="form-control" placeholder="Status" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Date" disabled></th>
							</tr>
						</thead>
						<tbody>
						</tbody>

					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>


	</section>
	<!-- /.content -->
	
</div>	




</html>