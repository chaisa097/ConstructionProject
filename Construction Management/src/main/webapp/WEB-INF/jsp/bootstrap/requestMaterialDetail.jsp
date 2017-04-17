<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<input type="image" src="images/back.jpg" onclick="back()"  width="48" height="48">
	<div class="form-group">
		<div class="panel panel-default">
		  <div class="panel-heading"><lable class="headPanal">Request MaterialDetail</lable>
				
			  </div>
		 </div>
		 
		 <button type="button" class="btn btn-primary" onclick="Save()">
			  <span class="glyphicon glyphicon-floppy-save"></span>
		</button> 
		
		 <div class="panel-body" style="margin-top:-25px;">
		  <div class="row">
		 		
				      
				<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
					<div  class="col-md-1" style="margin-top:10px; margin-bottom:5px" >
				    <button type="button" class="btn btn-default" onclick="addRow()">
			  		<span class="glyphicon glyphicon-text-height"></span>
			     	</button> 
			     	</div>
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px" >
						<select class="typeList"  id="type"  name="typeList" data-live-search="true" data-size="5" data-header="Select Type" disabled></select>
					</div>
			        
					<div class="col-md-3"  style="margin-top:10px; margin-bottom:20px">
						<select class="selectpicker show-tick show-menu-arrow" id="type"  name="materialList" data-live-search="true" data-size="5" data-header="Select Material" disabled></select>
					</div>
					
					<div class="col-md-3"  style="margin-top:10px; margin-bottom:20px">
							<input type="number" id="" class="form-control" placeholder="Amount of Request" name="quantityRequest" disabled>
					</div>
					
					
				</div>
			
				
		        <div class="panel panel-default filterable">
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