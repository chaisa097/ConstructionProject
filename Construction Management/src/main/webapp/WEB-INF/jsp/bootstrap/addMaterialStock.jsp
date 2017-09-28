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

 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-top:-89px;" >
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Receive 
        <small>Material</small>
      </h1>
     <ol class="breadcrumb">
			<li><a href="${domainSystem}receiveMaterial.html"><i
					class="fa fa-file"></i> Select Order</a></li>
		<li class="active">Receive Material</li>
		</ol>
    </section>

    <!-- Main content -->
    <section class="content">

      
       <div class="panel panel-info filterable">
           <div class="box">
            <div class="box-header">
              <div class="col-xs-2">
					<h3 style="margin-top:3px;margin-left: -8px; " class="box-title"> List Order Material</h3>
					</div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table  class="table">
                <thead>
                <tr class="filters">
               <th></th>
		                            <th><input type="text" class="form-control" placeholder="Type" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="MaterialName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Description" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="AmountOfOrder" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Unit" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Anotation" disabled></th>
		                 
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
          <div class="box box-default" name="addEditData">
        <!-- /.box-header -->
        <div class="box-body">
          <div class="row">
            <div class="col-xs-3">
            
            <select class="typeList form-control select2"  id="type"  name="typeList" data-live-search="true" data-size="5" data-header="Select Type" disabled ></select>
                    
            </div>
            <div class="col-xs-3">
            
           	<select class="form-control select2" id="material"  name="materialList" data-live-search="true" data-size="5" data-header="Select Material" disabled></select>
                    
            </div>
            
             <div class="col-xs-2">
            
          <input type="number" id="" class="form-control" placeholder="Amount of Receive" min="0" name="receiveQuantity" disabled>
                    
            </div>
            
             <div class="col-xs-2">
            
        <input type="number" id="" class="form-control" placeholder="Price"min="0" name="receivePrice" disabled>
                    
            </div>
              <div class="col-xs-1">
            
           <button    onclick="Save()" data-toggle="modal" data-target="#save"  class="btn btn-info pull-right">Add</button>
                    
            </div>
            
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
       
      </div>
      
       <div class="panel panel-info filterable">
           <div class="box">
            <div class="box-header">
              <div class="col-xs-2">
					<h3 style="margin-top:3px;margin-left: -8px; " class="box-title">List Export material</h3>
					</div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table  class="table-condensed">
                <thead>
                <tr class="filters">
           
		                       <th></th>
		                          <th><input type="text" class="form-control" placeholder="MaterialName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Description" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="AmountOfReceive" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Unit" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="price/Unit" disabled></th>
		                 
                </tr>
                </thead>
               <tbody>
		       </tbody>
                
              </table>
              
              <div class="box-footer">
				<button onclick="UpdateFinished()" type="submit"
					class="btn btn-warning pull-right">Save</button>
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