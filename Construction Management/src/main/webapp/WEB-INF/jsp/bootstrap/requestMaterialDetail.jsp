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
		  <div class="panel-heading"><lable class="headPanal">Request MaterialDetail</lable>
				
			  </div>
		 </div>
		
		 <div class="panel-body" style="margin-top:-25px;">
		  <div class="row">
		 		<div class="panel panel-warning">
		         <div class="panel-heading"><lable class="headPanal">Material</lable>
				      
			    	<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					<div  class="col-md-1" style="margin-top:20px; margin-bottom:5px" >					
				   <input type="image" src="images/add.png"  onclick="addRow()"   width="80" height="48">
			     	</div>
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px" >
					<label class="control-label-required">Type</label>
						<select class="typeList"  id="type"  name="typeList" data-live-search="true" data-size="5" data-header="Select Type" disabled></select>
					</div>
			        
					<div class="col-md-3"  style="margin-top:10px; margin-bottom:20px">
					<label>Material In Stock </label>
						<select class="selectpicker show-tick show-menu-arrow" id="type"  name="materialList" data-live-search="true" data-size="5" data-header="Select Material" disabled></select>
					</div>
					
					<div class="col-md-2"  style="margin-top:10px; margin-bottom:20px">
					<label>Amount of Request</label>
							<input type="number" id="" class="form-control" placeholder="Amount of Request" name="quantityRequest" disabled>
					</div>
					
					
						 <div class="col-md-2" style="margin-top:30px; margin-bottom:10px">
		        	<input type="image" src="images/Save2.png"  onclick="Save()"   width="40" height="40">  
				   </div>
					
				</div>
			
				</div>
		      </div>
		        <div class="panel panel-info filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Material List</h3>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th></th>
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
	</div>
</div>	
</html>