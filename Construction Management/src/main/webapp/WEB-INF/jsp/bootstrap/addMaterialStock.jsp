<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		
		 <div class="panel panel-info">
		  <div class="panel-heading"><lable class="headPanal">Receive Material</lable>
			  </div>
		 </div>		 
	   <div class="panel panel-warning  filterable">
	    <div class="pull-right">
	    <button type="button" class="btn btn-success" onclick="UpdateFinished()">
				     	<span class="glyphicon glyphicon-ok"></span> Finished
				        </button>
				        </div>
		            <div class="panel-heading">  		       
		             <div> <h3 class="panel-title">Order material List</h3> 
		             </div>         		              
		                  
		            </div>
		            <table class="table">
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
		 <div class="panel-body" style="margin-top:-25px;">
		  <div class="row">
				<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px" >
						<select class="typeList"  id="type"  name="typeList" data-live-search="true" data-size="5" data-header="Select Type" disabled></select>
					</div>
			        
					<div class="col-md-3"  style="margin-top:10px; margin-bottom:20px">
						<select class="selectpicker show-tick show-menu-arrow" id="material"  name="materialList" data-live-search="true" data-size="5" data-header="Select Material" disabled></select>
					</div>
					
					<div class="col-md-3"  style="margin-top:10px; margin-bottom:20px">
							<input type="number" id="" class="form-control" placeholder="Amount of Receive" min="0" name="receiveQuantity" disabled>
					</div>
					
					<div class="col-md-2"  style="margin-top:10px; margin-bottom:20px">
							<input type="number" id="" class="form-control" placeholder="Price"min="0" name="receivePrice" disabled>
					</div>
					
				<input type="image" src="images/Save2.png" onclick="Save()" width="48" height="48">
					
				</div>
				
		        <div class="panel panel-default filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Receive material List</h3>
		               
		            </div>
		            <table class="table-condensed">
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
		        </div>
		    
		        
		        
		        
		    </div>
		 </div>
	</div>
</div>	
</html>