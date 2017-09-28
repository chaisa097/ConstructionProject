<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
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
  <link rel="stylesheet" href="bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
</head>
<div name="statusSave" hidden="true"></div>
<!-- <div class="container">
		
	
		<div class="panel-body" style="margin-top: -25px;">
		<button type="button" class="btn btn-primary" onclick="listRequestMaterial()">
					<span class="glyphicon glyphicon-duplicate"></span> History Of RequestMaterial
				   </button> 
				   
				   <button type="button" class="btn btn-warning" onclick="exportMaterialConfirm()">
					<span class="glyphicon glyphicon-duplicate"></span>  History Of ImportMaterial
				   </button> 
		

	<div class="form-group"  style="margin-top: 15px; margin-bottom:5px">
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
</div> -->


	  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-top:-89px;" >
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Own 
        <small>Project</small>
      </h1>
     <ol class="breadcrumb">
			<li><a href="${domainSystem}home.html"><i
					class="fa fa-dashboard"></i>Home</a></li>
		<li class="active">Own Project</li>
		</ol>
    </section>

    <!-- Main content -->
    <section class="content">

      
       <div class="panel panel-info filterable">
           <div class="box">
            <div class="box-header">
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table  class="table">
                <thead>
                <tr class="filters">
               <th></th>
		    	<th><input type="text" class="form-control"
									placeholder="ProjectName" disabled></th>
							<th><input type="text" class="form-control"
									placeholder="Budget" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="Material Used" disabled></th>	
								<th><input type="text" class="form-control"
									placeholder="StatusProject" disabled></th>
                </tr>
                </thead>
               <tbody>
		       </tbody>
                
              </table>
              
               <div class="pull-right">
		              <div id="page-selection"></div>
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