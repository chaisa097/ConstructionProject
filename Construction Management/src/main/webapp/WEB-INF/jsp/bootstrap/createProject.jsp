<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
	<input type="image" src="images/back4.ico" onclick="back()"  width="48" height="48">
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
								<lable>ProjectName</lable>
								<input id="projectName" type="text" class="form-control"
									placeholder="Project Name" name="projectName">
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Description</lable>
								<textarea id="description" class="form-control"
									placeholder="Description" rows="3" cols="10" name="description"></textarea>
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Address</lable>
								<textarea id="address" class="form-control"
									placeholder="Address of Construction Site" rows="3" cols="10"
									name="address"></textarea>
							</div>

							<div class="col-md-4"
								style="margin-top: 20px; margin-bottom: 10px">
								<lable>Province</lable>
								<select class="selectpicker show-tick show-menu-arrow" id="pv"
									name="provinceList" data-live-search="true" data-size="5"
									data-header="Select Province" ></select>

							</div>

							<div class="col-md-4"
								style="margin-top: 20px; margin-bottom: 10px">
								<lable> ProjectManager</lable>
								<select class="selectpicker show-tick show-menu-arrow" id="emp"
									name="employeeList" data-live-search="true" data-size="5"
									data-header="Select ProjectManager" ></select>

							</div>


							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CompleteStatus(0-100%)</lable>
								<input id="percentStatus" class="form-control" type="number"
									min="0" max="100" step="10" name="percentStatus" >
							</div>



							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>StartDate</lable>
								<input type="date" class="form-control" name="startDate"
									id="startDate" >
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>FinishDate</lable>
								<input type="date" class="form-control" name="finishDate"
									id="finishDate">
							</div>
							
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Critical Budget(0-100%)</lable>
								<input type="number" class="form-control" min="0" max="100"
									step="5" name="criticalBudget" id="criticalBudget">
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
									id="customerName" >
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CustomerPhone</lable>
								<input type="text" class="form-control"
									placeholder="Customer Phone" name="customerPhone"
									id="customerPhone" >
							</div>
							
							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Budget</lable>
								<input type="number" class="form-control" placeholder="Budget"
									name="budget" id="bugget" >
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