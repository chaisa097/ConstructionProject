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

		
		 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-top:-89px;" >
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       
       Material Detail 

      </h1>
      <ol class="breadcrumb">
         <li><a href="#"><i class="fa fa-file-o"></i>View Material Detail Used</a></li>
 
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- /.box -->
       <div class="panel panel-info filterable">
           <div class="box">
            <div class="box-header">
               <div class="row">
               
                    <div class="col-xs-1">
					<h4>No :</h4>
					</div>
					<div class="col-xs-9">
					<h4  style="margin-left:-30px;" id="exportMaterialNo"> </h4>
					</div>

					<div class="col-xs-1">
					<h4> Date :</h4>
					</div>
					<div class="col-xs-1">
					<h4 style="margin-left:-30px;" id="exportDate"> </h4>
					</div>
					
					<div class="col-xs-1">
					<h4> Status :</h4>
					</div>
					<div class="col-xs-2">
					<h4 style="margin-left:-30px;" id="status"> </h4>
					</div>
					
					<div class="col-xs-2">
					<h4>  ProjectName :</h4>
					</div>
					<div class="col-xs-2">
					<h4 style="margin-left:-30px;" id="projectName"> </h4>
					</div>
			

            </div>
             <div class="box-footer">
				</div>

			</div>
			
            <!-- /.box-header -->
            <div class="box-body">
              <table  class="table">
                <thead>
                <tr class="filters">
		                        <th><input type="text" class="form-control" placeholder="MaterialName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Description" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="AmountOfimport" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Unit" disabled></th>
                  </tr>
                </thead>
               <tbody>
		       </tbody>
              </table>
            </div>
            
              <div class="box-footer">
       <!--     <button type="button" class="btn btn-primary" onclick="back()">
					Back
				   </button>  -->
				</div>
            <!-- /.box-body -->
            </div>
             <!-- /.box -->
          </div>
         
  
    </section>
    <!-- /.content -->
  </div>
</html>