<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<link rel="stylesheet" href="css/base/createproject.css">
<script src="webjars/jquery/2.1.1/jquery.min.js"></script>
 <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="dist/css/sb-admin-2.css">
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <script src="metisMenu/metisMenu.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</head>

<div name="statusSave" hidden="true"></div>

<div class="container">
	<div class="form-group">
		<div class="panel panel-info">
			<div class="panel-heading">
				<lable class="headPanal">Construction Project</lable>
				<div style="margin-top: 10px; margin-bottom: 2px">
				</div>
			</div>
		</div>
    
		<div class="panel-body" style="margin-top: -25px;">
			<div class="row">
				<div class="panel panel-info">

					<div class="panel-heading">
						<lable class="headPanal"> Project Information</lable>	
					</div>
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
						<div class="container"> 
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable for="proName">ProjectName</lable>
								<input id="proName" type="text" class="form-control"
									placeholder="Project Name" name="projectName" pattern="[A-Za-z]{3,5}" required  >
									<span class="error">This field is required</span>
							</div>
                        <form id="myform">
							<div class="col-md-4"
								style="margin-top: 25px; margin-bottom: 10px">
								<lable>Province</lable>
								<select class="selectpicker show-tick show-menu-arrow" id="province"
									name="provinceList" data-live-search="true" data-size="5"
									data-header="Select Province"   required=""></select>	
									
							</div>
                        </form>
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Address</lable>
								<textarea id="address" class="form-control"
									placeholder="Address of Construction Site" rows="3" cols="10"
									name="address" required="" ></textarea>
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CompleteStatus(0-100%)</lable>
								<span id="slider_value" style="color:red;"></span>
								<input id="Status" class="form-control" type="range"
									min="0" max="100" step="5"  value="0" onchange="show_value(this.value);" required=""  name="percentStatus" >
                         
							</div>

							<div class="col-md-4"
								style="margin-top: 20px; margin-bottom: 10px">
								<lable> ProjectManager</lable>
								<select class="selectpicker show-tick show-menu-arrow" id="employee"
									name="employeeList" data-live-search="true" data-size="5"
									data-header="Select ProjectManager" required=""></select>
   
							</div>


							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
							<lable>Description</lable>
								<textarea id="descript" class="form-control"
									placeholder="Description" rows="3" cols="10" name="description" required="" ></textarea>		
									
							</div>



							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
							<lable for="critical">Critical Budget(0-100%)</lable>
								<input type="number" class="form-control" min="0" max="100"
								step="1" name="criticalBudget" id="critical" required="" maxlength="3" >
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>StartDate</lable>
								<input type="date" class="form-control" name="startDate"
									id="startDate" required="">
							
							</div>
							
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>FinishDate</lable>
								<input type="date" class="form-control" name="finishDate"
									id="finishDate" required=""  >
				
							</div>
						</div>

					</div>

				</div>

				<div class="panel panel-info">
					<div class="panel-heading">
						<lable class="headPanal"> Customer Information</lable>
					</div>
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
						<div class="container">
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CustomerName</lable>
								<input type="text" class="form-control"
									placeholder="Customer Name" name="customerName"
									id="cusName" required="" >
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CustomerPhone</lable>
								<input type="text" class="form-control"
									placeholder="Customer Phone" name="customerPhone"
									id="cusPhone" required="" >
							</div>
							
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Budget</lable>
								<input type="number" class="form-control" placeholder="Budget"
									name="budget" id="budget" min="0" required="" >
							</div>
							
						
						</div>
					</div>
                    
				</div>

			

			</div>
			<div class="pull-right">
		<input type="image" src="images/Save2.png"  onclick="save()"   width="48" height="48">
		</div>
		</div>
		
	</div>
	
	
	
</div>
</html>

