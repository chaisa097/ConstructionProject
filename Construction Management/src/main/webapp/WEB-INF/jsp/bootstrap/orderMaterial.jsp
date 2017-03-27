<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
   <div class="container">              	
		    <div class="panel-body" >	
		        <div class="row">		  
		 		<button type="button" class="btn btn-default" onclick="addRow()">
						<span class="glyphicon glyphicon-edit"></span> Insert
				</button>
				 
		              
				<div class="row" style="margin-top:10px; margin-bottom:-5px" name="addEditData">
				
				 	 <div class="col-md-12">				
				   <div class="col-md-3">
				    <lable>OrderMaterialNo</lable>
						<input id="ordermaterialNo"  type="text" class="form-control"  name="projectName"  disabled >
				   </div>
				 
				  				   
				    <div class="col-md-3"  >
				     <lable>Status</lable>
						<input id="status"  type="text" class="form-control"  name="status"  disabled >
				   </div>
				  					
				  </div>
				 
				
				</div>
				</div>
					</div>
				 
				 
				 
		    </div>
		 </div>
	</div>

</html>