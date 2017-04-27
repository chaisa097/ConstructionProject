<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
 <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="dist/css/sb-admin-2.css">
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="metisMenu/metisMenu.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</head>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
	
		<div class="col-md-12">
			<button type="button" class="btn btn-warning" onclick="SendOrder()">
					<span class="glyphicon glyphicon-send"></span> Send Order
				   </button> 
		</div>
			<div class="col-md-12">


				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>OrderDate</label> <input type="date" class="form-control"
						id="orderMaterialDate" name="orderMaterialDate" disabled>
				</div>

				<div class="col-md-4"></div>

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>OrderNo</label> <input type="text" class="form-control"
						id="orderNo" placeholder="orderNo" name="orderMaterialNo"
						disabled>
				</div>


			</div>
			<div class="col-md-12">

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>Contact OrderOwner</label>
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

		 <div class="panel panel-default filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Material Detail</h3>
		              
		            </div>
		            <table class="table">
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
		    </div>
		 </div>

</html>
		
		
		