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
	<div class="form-group">
		<div class="panel-body" style="margin-top: -25px;">
			<div class="row">
                 <button type="button" class="btn btn-success" onclick="createProject()">
					<span class="glyphicon glyphicon-plus"></span> New Project
				   </button> 
				<div class="panel panel-info filterable">
					<div class="panel-heading">
						<h3 class="panel-title">List Project</h3>
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
									placeholder="ProjectName" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="Povince" disabled></th>

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
        Manage
        <small>Project</small>
      </h1>
     
      <ol class="breadcrumb">
        <li><a href="${domainSystem}home.html"><i class="fa fa-dashboard"></i>Home</a></li>
        <li class="active">Manage Project</li>
      </ol>
      
      
      
      
    </section>

    <!-- Main content -->
    <section class="content">
    
    
    	
		
			<!-- /.box-body -->
			 <div class="box-header">
			 	<div   class="col-xs-3">
			  

          <button style="margin-top:-10px;margin-bottom: -10px;margin-left: -25px;" class="btn btn-app"  onclick="createProject()" > <i class="fa  fa-plus"></i>New Project</button>
         
      </div>
			</div>
			
      <!-- /.box -->
       <div class="panel panel-info filterable">
           <div class="box">
            <div class="box-header">
           
             <h3 class="box-title">Project List</h3>
          
             
              
               <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Search</button>
		                </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table  class="table">
                <thead>
                <tr class="filters">
               <th></th>
		       <th><input  type="text" class="form-control" placeholder="ProjectName" disabled></th>
               <th><input  type="text" class="form-control" placeholder="Province" disabled></th>
                 <th><input  type="text" class="form-control" placeholder="StartDate(DD/MM/YYYY)" disabled></th>
               <th><input  type="text" class="form-control" placeholder="FinishedDate(DD/MM/YYYY)" disabled></th>
                    <th><input  type="text" class="form-control" placeholder="Budget(THB)" disabled></th>
                 <th><input  type="text" class="form-control" placeholder="HireEmployee(THB)" disabled></th>
               <th><input  type="text" class="form-control" placeholder="MaterialUsed(THB)" disabled></th>
                   <th ><input style="text-align:right"  type="text" class="form-control" placeholder="TotalExpenses(THB)" disabled></th>
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
		 
		 

		 <!-- delete alert modal box -->
<div class="modal fade bs-example-modal-sm" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" rowId="">
  <div class="modal-dialog modal-xs" role="document">
    <div class="modal-content">
      <div class="modal-header">
      	 <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Warning</h4>
      </div>
       <div class="modal-body" >
       <p>Do you really want to delete?</p>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn-lg btn-danger" data-dismiss="modal" onclick="deleteRow()">Delete</button>
        <button type="button" class="btn-lg btn-warning" data-dismiss="modal">Cancel</button>
       
      </div>
    </div>
  </div>
</div>
		 <div class="modal fade" id="save" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class=" modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Warning</h4>
        </div>
        <div class="modal-body">
          <p>Province has been saved.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn-lg btn-primary" data-dismiss="modal">Close</button>
          </div>
       
      </div>
      
    </div>
  </div>




</html>