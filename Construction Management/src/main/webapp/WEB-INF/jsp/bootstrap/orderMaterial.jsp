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

		 
		  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-top:-89px;" >
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Order
        <small>Material</small>
      </h1>
      <ol class="breadcrumb">
       <li><a href="${domainSystem}listOrder.html"><i class="fa fa-opencart"></i>Order Material</a></li>
         <li><a href="${domainSystem}OrderMaterial.html"><i class="fa fa-file-o"></i>Order</a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
        <div class="panel panel-info filterable">
           <div class="box">
            <div class="box-header">
              <h3 class="box-title">Header Order List</h3>
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
		      <th><input type="text" class="form-control"
									placeholder="OrderNo" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="status" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="OrderDate" disabled></th>
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
      <!-- SELECT2 EXAMPLE -->
      <div class="box box-default" name="addEditData">
        <div class="box-header with-border">
          <h3 class="box-title">New Header Order</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
          <div class="row">
            <div class="col-md-1">
             <label> Order Date:</label>
                    
            </div>
             <div class="col-md-2">
                <lable class="headPanal"><p id="date"></p></lable>
            </div>
             <div class="col-md-1">
                <label>Contact</label>
            </div>
            
            
            <!-- /.col -->
            <div class="col-md-6">
            
					<textarea id="address" class="form-control"
						placeholder="Address/Phone" rows="3" cols="10" name="address"></textarea>
            
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
        <div class="box-footer">
          <button    onclick="Save()" data-toggle="modal" data-target="#save"  class="btn btn-info pull-right">Save</button>
        </div>
      </div>
      <!-- /.box -->
     
         
  
    </section>
    <!-- /.content -->
  </div>
		 
		 

		
	
	
	
	
</html>