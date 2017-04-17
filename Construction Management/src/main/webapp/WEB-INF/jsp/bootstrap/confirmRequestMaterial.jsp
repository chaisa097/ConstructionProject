<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<input type="image" src="images/back.jpg" onclick="backFunction()"  width="48" height="48">
	<div class="form-group">
	
		<div class="col-md-12">
			<button type="button" class="btn btn-success" onclick="ConfirmRequest()">
					<span class="glyphicon glyphicon-ok"></span> Confirm RequestMaterial
				   </button> 
		<button type="button" class="btn btn-danger" onclick="rejectRequest()">
					<span class="glyphicon glyphicon-remove"></span> Reject RequestMaterial
				   </button> 
		</div>
			<div class="col-md-12">


				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>Use  Material Date</label> <input type="date" class="form-control"
						id="orderMaterialDate" name="useMaterialDate" disabled>
				</div>

				<div class="col-md-4"></div>

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>RequestNo</label> <input type="text" class="form-control"
						id="requestNo" placeholder="requestNo" name="requestMaterialNo"
						disabled>
				</div>


			</div>
			<div class="col-md-12">

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>ContactOwnerRequest</label>
					<textarea id="contactOwner" class="form-control"
						placeholder="Address/Phone" rows="3" cols="10" name="contactOwner"
						disabled></textarea>
				</div>

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
				</div>
				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>Status</label> <input type="text" class="form-control"
						id="Status" placeholder="Status" name="status" disabled>
				</div>
			</div>

		 <div class="panel panel-default filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Material Detail</h3>
		              
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                        <th><input type="text" class="form-control" placeholder="MaterialName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Description" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="AmountOfRequest" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Unit" disabled></th>
		            
		                    </tr>
		                </thead>
		                <tbody>
		                </tbody>
		            </table>
		        </div>
		    </div>
		 </div>

</html>
		
		