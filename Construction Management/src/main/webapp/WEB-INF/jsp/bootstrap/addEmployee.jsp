<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
		<div class="panel-body" style="margin-top: -25px;">
			<div class="row">
		<input type="image" src="images/back.jpg" onclick="back()"  width="48" height="48">
				<div class="panel panel-info">
					<div class="panel-heading">
						<lable class="headPanal"> Project </lable>
								<input id="projectName" type="text" class="form-control"
									placeholder="Project Name" name="projectName" disabled>
					</div>
                    </div>
           
						<button type="button" class="btn btn-primary" onclick="save()">
							<span class="glyphicon glyphicon-floppy-save"></span>
						</button>


						<div class="row" style="margin-top: 10px; margin-bottom: -5px"
							name="addEditData">
							<div class="col-md-1"
								style="margin-top: 10px; margin-bottom: 5px"></div>

							<div class="col-md-1"
								style="margin-top: 10px; margin-bottom: 5px">

								<button type="button" class="btn btn-default" onclick="addRow()">
									<span class="glyphicon glyphicon-text-height"></span>
								</button>
							</div>

							<div class="col-md-3"
								style="margin-top: 10px; margin-bottom: 20px">
								<select class="selectpicker show-tick show-menu-arrow"
									id="employee" name="employeeList" data-live-search="true"
									data-size="5" data-header="Select Employee" disabled></select>
							</div>

							<div class="col-md-3"
								style="margin-top: 10px; margin-bottom: 5px">
								<input type="text" class="form-control" id="amountOfmonth"
									placeholder="amountOfMonth" name="amountOfMonth" disabled>
							</div>


						</div>






						<div class="panel panel-default filterable">
							<div class="panel-heading">
								<h3 class="panel-title">Employee List</h3>
								
							</div>
							<table class="table">
								<thead>
									<tr class="filters">
										<th></th>
										<th><input type="text" class="form-control"
											placeholder="EmployeeName" disabled></th>
										<th><input type="text" class="form-control"
											placeholder="Position" disabled></th>
										<th><input type="text" class="form-control"
											placeholder="Salary" disabled></th>
										<th><input type="text" class="form-control"
											placeholder="AmountOfWorking/month" disabled></th>
										<th><input type="text" class="form-control"
											placeholder="Total/people" disabled></th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
							<div class="col-md-4">
							</div>

						  <div class="col-md-2">
						  </div>
							<div class="col-md-3">
								<lable class="headPanal"> Total Employee Hire:</lable>
							</div>
							
							<div class="col-md-3">
							<input id="projectName" type="text" class="form-control"
									placeholder="totalHireEmployee" name="totalHireEmployee" disabled>
							</div>
						
				</div>
			</div>
		</div>
	</div>
</html>