<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<!-- <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="dist/css/sb-admin-2.css">
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="metisMenu/metisMenu.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>-->
  
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
<div class="content-wrapper" style="margin-top: -89px;">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Project
		</h1>
		<ol class="breadcrumb">
			<li><a href="${domainSystem}home.html"><i
					class="fa fa-dashboard"></i>Home</a></li>
					<li><a href="${domainSystem}listProjectPM.html"><i
					class="fa fa-folder"></i>Manage Project</a></li>
			<li class="active">View Project</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">

		<!-- /.box -->
			<div class="box">
				<table class="table">
		                <thead>
		                    <tr>
		                                       		                    		                   
		                    </tr>
		                </thead>
		                <tbody>
		                
		                     <tr>
                             <td>ProjectName</td>
                             <td><p id="projectName"></p></td>                                    
                            </tr>
                          
		                   <tr>
                             <td>Description</td>
                              <td><p id="description"></p> </td>                            
                          </tr>                                                                            
		                  <tr>
                             <td>Address</td>
                              <td><p id="address"></p></td>                            
                          </tr>
		               
		                    <tr>
                             <td>CompleteStatus(1-100%) </td>
                         
                              <td><p id="percentStatus" ></p></td>                            
                          </tr>
		                						
				          
		                   <tr>
                             <td>StartDate</td>
                              <td><p id="startDate"></p> </td>                            
                          </tr>
                          
                          <tr>
                             <td>FinishDate</td>
                              <td><p id="finishDate"></p> </td>                            
                          </tr>
                          
                           <tr>
                             <td>CustomerName</td>
                              <td><p id="customerName"></p> </td>                            
                          </tr>
                              <tr>
                          
                              <tr>
                             <td>CustomerPhone</td>
                              <td><p id="customerPhone"></p></td>                            
                          </tr>
                          
                          
                            <tr>
                             <td>Budget</td>
                              <td><p id="budget"></p></td>                            
                          </tr>
                                                
                              <tr>
                             <td>TotalHireEmployee</td>
                              <td><p id="totalHireEmployee"></p> </td>                            
                             </tr>
                            <tr>                          
                             <td>TotalUsedMaterial</td>
                              <td><p id="totalUseMaterial"></p> </td>                            
                          </tr>
                           <tr>                                                           
                             <td>TotalExpenseInConstruction</td>
                              <td><p id="totalExpense"></p></td>                            
                          </tr>
                          <tr>                                                           
                             <td>Critical Budget(1-100%)</td>
                              <td><p id="criticalBudget"></p> </td>                            
                          </tr>
                          
                                        
		                </tbody>
		            </table>
				
			<!-- /.box -->
		</div>

	</section>
	<!-- /.content -->
	
</div>	
</html>