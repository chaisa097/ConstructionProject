<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">

		<div class="panel panel-default">
			<div class="panel-heading">
				<lable class="headPanal">Requisition Material</lable>
			</div>
		</div>
		<div class="col-md-12">
			<button type="button" class="btn btn-default" onclick="addRow()">
				<span class="glyphicon glyphicon-pencil"></span>
			</button>
		</div>
		<div class="row" style="margin-top: 10px; margin-bottom: -5px"
			name="addEditData">
			<div class="col-md-12">


				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>UsingMaterialDate</label> <input type="date" class="form-control"
						id="orderMaterialDate" name="orderMaterialDate" disabled>
				</div>

				<div class="col-md-4"></div>

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>RquisitionNo</label> <input type="text" class="form-control"
						id="orderNo" placeholder="orderNo." name="orderMaterialNo"
						disabled>
				</div>


			</div>
			<div class="col-md-12">

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>ContactOwnerRquisition</label>
					<textarea id="address" class="form-control"
						placeholder="Address/Phone" rows="3" cols="10" name="address"
						disabled></textarea>
				</div>

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
				</div>
				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>Status</label> <input type="text" class="form-control"
						id="Status" placeholder="Status" name="status" disabled>
				</div>
			</div>

		</div>

		<div class="panel-body" style="margin-top: -25px;">
			<div class="row">

				<div class="panel panel-default filterable">
					<div class="panel-heading">
						<h3 class="panel-title">Requisition List</h3>
						<div class="pull-right">
							<button class="btn btn-default btn-xs btn-filter">
								<span class="glyphicon glyphicon-filter"></span>Filter
							</button>
						</div>
					</div>
					<table class="table">
						<thead>
							<tr class="filters">
								<th><input type="text" class="form-control"
									placeholder="manage" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="RequisitionNo" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="status" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="RquisitionDate" disabled></th>

							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</div>
</html>