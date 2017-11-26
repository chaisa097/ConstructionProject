<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
 <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
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
  <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
<script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/jszip.min.js"></script>
</head>
<div name="statusSave" hidden="true"></div>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-top:-89px;" >
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
       Approve Order
        <small>Material</small>
      </h1>
      <ol class="breadcrumb">
         
        <li><a href="${domainSystem}listOrderPM.html"><i class="fa fa-paper"></i> Order Material</a></li>
         <li><a href="#"><i class="fa fa-folder"></i> Approve Order Material</a></li>
      </ol>
    </section>
 <div id="content">
    <!-- Main content -->
    <section class="content">
      <!-- /.box -->
       <div class="panel panel-info filterable">
        
           <div class="box">
          
            <div class="box-header">
               <div class="row">
               
                    <div class="col-xs-1">
					<h4>orderNo :</h4>
					</div>
					<div class="col-xs-9">
					<h4  style="margin-left:-30px;" id="orderMaterialNo"> </h4>
					</div>

					<div class="col-xs-1">
					<h4>OrderDate:</h4>
					</div>
					<div class="col-xs-1">
					<h4 style="margin-left:-30px;" id="orderMaterialDate"> </h4>
					</div>
					
					<div class="col-xs-1">
					<h4> Status :</h4>
					</div>
					<div class="col-xs-2">
					<h4 style="margin-left:-30px;" id="status"> </h4>
					</div>
					
					<div class="col-xs-2">
					<h4> ContactOrderOwner :</h4>
					</div>
					<div class="col-xs-2">
					<h4 style="margin-left:-30px;" id="address"> </h4>
					</div>
			
           </div>
           
            </div>
             <div class="box-footer">
				</div>
			
            <!-- /.box-header -->
            <div class="box-body">
              <table id="exportTable"  class="table">
                <thead>
                <tr class="filters">
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
        
              <div class="box-footer">
               <div class="pull-right">
                  <button type="button" class="btn btn-danger" onclick="rejectOrder()">
					<span class="glyphicon glyphicon-remove"></span> Reject
				   </button> 
		            	<button type="button" class="btn btn-success" onclick="ConfirmOrder()">
					<span class="glyphicon glyphicon-ok"></span> Confirm
				   </button> 
				<button id="exportButton" type="button" class="btn btn-success" onclick="exportPDF()" >
					<span class="fa fa-file-pdf-o"></span> PDF file
				   </button> 
		              </div>
              
              
				</div>
            <!-- /.box-body -->
            </div>
             <!-- /.box -->
          </div>
         
  
    </section>
   </div>
    
            <div id="editor"></div>
    <!-- /.content -->
  </div>

</html>
		
		
		